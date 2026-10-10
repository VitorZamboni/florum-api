package br.com.florum.service.impl;

import br.com.florum.dto.order.CreateOrderDTO;
import br.com.florum.dto.product.ProductQuantityDTO;
import br.com.florum.enuns.OrderStatusEnum;
import br.com.florum.error.exceptions.BadRequestException;
import br.com.florum.error.exceptions.NotFoundException;
import br.com.florum.error.exceptions.UnprocessableException;
import br.com.florum.model.*;
import br.com.florum.repository.AddressRepository;
import br.com.florum.repository.OrderRepository;
import br.com.florum.service.IAddressService;
import br.com.florum.service.ICartService;
import br.com.florum.service.ICouponService;
import br.com.florum.service.IOrderService;
import br.com.florum.service.IProductService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements IOrderService {
    private final OrderRepository orderRepository;
    private final IProductService productService;
    private final AddressRepository addressRepository;
    private final ICouponService couponService;
    private final IAddressService addressService;
    private final ICartService cartService;

    public OrderServiceImpl(
            OrderRepository orderRepository,
            IProductService productService,
            AddressRepository addressRepository,
            ICouponService couponService,
            IAddressService addressService,
            ICartService cartService
    ) {
        this.orderRepository = orderRepository;
        this.productService = productService;
        this.addressRepository = addressRepository;
        this.couponService = couponService;
        this.addressService = addressService;
        this.cartService = cartService;
    }

    @Override
    @Transactional
    public Long save(CreateOrderDTO orderDTO, User user) {
        Map<Long, Integer> quantityByProduct = ProductQuantityDTO.sumByProduct(orderDTO.getItems());
        Map<Long, Product> productsById = productService.findAllByIdsOrThrow(quantityByProduct.keySet());

        Address address = addressRepository.findAddressByIdAndUserId(orderDTO.getAddressId(), user.getId());
        if (address == null) {
            throw new NotFoundException("Address not found with id: " + orderDTO.getAddressId());
        }
        var itemsOutOfStock = quantityByProduct.entrySet().stream()
            .filter(item -> productsById.get(item.getKey()).getStock() < item.getValue())
            .map(Map.Entry::getKey)
            .toList();
        if (!itemsOutOfStock.isEmpty()) {
            throw new UnprocessableException("Requested quantity exceeds available stock" + itemsOutOfStock);
        }

        Coupon coupon = null;
        if (orderDTO.getCouponCode() != null && !orderDTO.getCouponCode().isBlank()) {
            coupon = couponService
                .findByCodeCoupon(orderDTO.getCouponCode());
        }

        Order order = Order.builder()
            .user(user)
            .address(address)
            .shipping(addressService.calculateShipping(address))
            .paymentTypeEnum(orderDTO.getPaymentType())
            .status(OrderStatusEnum.PENDING)
            .coupon(coupon)
            .build();

        List<OrderItem> items = quantityByProduct.entrySet().stream().map(item -> {
            Product product = productsById.get(item.getKey());
            BigDecimal finalPrice = product.getPrice()
                .multiply(BigDecimal.ONE.subtract(product.getDiscount()))
                .setScale(2, RoundingMode.HALF_EVEN);
            return OrderItem.builder()
                .quantity(item.getValue())
                .price(finalPrice)
                .product(product)
                .order(order)
                .build();
        }).toList();

        BigDecimal subtotal = items.stream()
            .map(item -> item.getPrice().multiply(BigDecimal.valueOf(item.getQuantity())))
            .reduce(BigDecimal.ZERO, BigDecimal::add);

        if (coupon != null && coupon.getDiscountAmount().compareTo(subtotal) >= 0) {
            throw new BadRequestException("Coupon discount must be less than the order total");
        }

        order.getOrderItems().addAll(items);
        BigDecimal discount = coupon != null ? coupon.getDiscountAmount() : BigDecimal.ZERO;
        order.setDiscount(discount);
        order.setTotal(subtotal.add(order.getShipping()).subtract(discount));
        orderRepository.save(order);

        quantityByProduct.forEach((key, value) -> {
            Product product = productsById.get(key);
            product.setStock(product.getStock() - value);
        });
        cartService.clearCart(user.getId(), quantityByProduct.keySet());

        return order.getId();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Order> findAll(Long userId) {
        return this.orderRepository.findByUserId(userId);
    }

    @Override
    @Transactional(readOnly = true)
    public Order findById(Long id, Long userId) {
        Order order = this.orderRepository.findOrderByIdAndUserId(id, userId);

        if (order == null){
            throw new NotFoundException("Order not found");
        }

        return order;
    }
}

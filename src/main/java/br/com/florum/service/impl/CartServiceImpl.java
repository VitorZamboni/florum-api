package br.com.florum.service.impl;

import br.com.florum.dto.cart.CreateCartDTO;
import br.com.florum.dto.product.ProductQuantityDTO;
import br.com.florum.model.Cart;
import br.com.florum.model.CartItem;
import br.com.florum.model.Product;
import br.com.florum.model.User;
import br.com.florum.repository.CartRepository;
import br.com.florum.service.ICartService;
import br.com.florum.service.IProductService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class CartServiceImpl implements ICartService {
    private final CartRepository cartRepository;
    private final IProductService productService;


    public CartServiceImpl(
        CartRepository cartRepository,
        IProductService productService
    ) {
        this.cartRepository = cartRepository;
        this.productService = productService;
    }

    @Override
    @Transactional(readOnly = true)
    public Cart findByUser(Long userId) {
        return this.cartRepository.findCartByUserId(userId);
    }

    @Override
    @Transactional
    public Cart save(CreateCartDTO cartDTO, User user) {
        Map<Long, Integer> quantityByProduct = ProductQuantityDTO.sumByProduct(cartDTO.getItems());
        Map<Long, Product> productsById = productService.findAllByIdsOrThrow(quantityByProduct.keySet());

        Cart cart = cartRepository.findCartByUserId(user.getId());
        if (cart == null) {
            cart = Cart.builder().user(user).build();
            cartRepository.save(cart);
        }

        Map<Long, CartItem> existingByProduct = cart.getCartItems().stream()
            .collect(Collectors.toMap(item -> item.getProduct().getId(), Function.identity()));
        for (var entry : quantityByProduct.entrySet()) {
            Long productId = entry.getKey();
            Integer quantity = entry.getValue();

            CartItem existing = existingByProduct.get(productId);
            if (existing != null) {
                existing.setQuantity(existing.getQuantity() + quantity);
            } else {
                CartItem cartItem = CartItem.builder()
                    .cart(cart)
                    .quantity(quantity)
                    .product(productsById.get(productId))
                    .build();
                cart.getCartItems().add(cartItem);
            }
        }
        return cart;
    }

    @Override
    @Transactional
    public void clearCart(Long userId, Set<Long> productIds) {
        Cart cart = cartRepository.findCartByUserId(userId);
        if (cart == null) {
            return;
        }
        cart.getCartItems().removeIf(item -> productIds.contains(item.getProduct().getId()));
    }
}

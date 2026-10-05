package br.com.florum.service.impl;

import br.com.florum.dto.cart.CreateCartDTO;
import br.com.florum.dto.cart.CreateCartItemDTO;
import br.com.florum.model.Cart;
import br.com.florum.model.CartItem;
import br.com.florum.model.Product;
import br.com.florum.model.User;
import br.com.florum.repository.CartRepository;
import br.com.florum.repository.ProductRepository;
import br.com.florum.service.ICartService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class CartServiceImpl implements ICartService {
    private final CartRepository cartRepository;
    private final ProductRepository productRepository;

    public CartServiceImpl(
        CartRepository cartRepository,
        ProductRepository productRepository
    ) {
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public Cart findByUser(Long userId) {
        return this.cartRepository.findCartByUserId(userId);
    }

    @Override
    @Transactional
    public Cart save(CreateCartDTO cartDTO, User user) {
        var ids = cartDTO.getItems().stream()
            .map(CreateCartItemDTO::getProductId).toList();
        var products = productRepository.findAllById(ids);

        Map<Long, Product> productsById = products.stream()
            .collect(Collectors.toMap(Product::getId, Function.identity()));
        List<Long> notFound = ids.stream()
            .filter(id -> !productsById.containsKey(id))
            .toList();

        if (!notFound.isEmpty()) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "Produtos não encontrados com os ids : " + notFound
            );
        }
        Map<Long, Integer> quantityByProduct = cartDTO.getItems().stream()
            .collect(Collectors.toMap(
                CreateCartItemDTO::getProductId,
                CreateCartItemDTO::getQuantity,
                Integer::sum
            ));
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
}

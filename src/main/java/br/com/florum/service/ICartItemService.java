package br.com.florum.service;

import br.com.florum.dto.cart.UpdateCartItemDTO;

public interface ICartItemService {
    void updateCartItem(Long id, UpdateCartItemDTO cartItem, Long userId);
    void deleteById(Long id, Long userId);
    Integer countsByUserId(Long cartId);
}

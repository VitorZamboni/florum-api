package br.com.florum.service;

import br.com.florum.model.CartItem;

public interface ICartItemService {
    CartItem findById(Long id);
    CartItem save(CartItem cartItem);
    void deleteById(Long id);
    Integer countsByCartId(Long cartId);
}

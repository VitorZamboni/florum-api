package br.com.florum.service;

import br.com.florum.dto.cart.CartItemDTO;
import br.com.florum.model.CartItem;

import java.util.List;

public interface ICartItemService {
    CartItem findById(Long id);
//    CartItem save(CartItem cartItem);
    CartItem save(List<CartItemDTO> items);
    void deleteById(Long id);
    Integer countsByUserId(Long cartId);
}

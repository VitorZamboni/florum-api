package br.com.florum.service;

import br.com.florum.dto.cart.CreateCartDTO;
import br.com.florum.model.Cart;
import br.com.florum.model.User;

import java.util.Set;

public interface ICartService {
    Cart findByUser(Long id);
    Cart save(CreateCartDTO cart, User user);
    void clearCart(Long userId, Set<Long> productIds);
}

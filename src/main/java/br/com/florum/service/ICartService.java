package br.com.florum.service;

import br.com.florum.model.Cart;

public interface ICartService {
    Cart findByUser(Long id);
    Cart save(Cart cart);
    void delete(Long id);
}

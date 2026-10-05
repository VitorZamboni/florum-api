package br.com.florum.service;

import br.com.florum.dto.cart.CreateCartDTO;
import br.com.florum.model.Cart;
import br.com.florum.model.User;

public interface ICartService {
    Cart findByUser(Long id);
    Cart save(CreateCartDTO cart, User user);
}

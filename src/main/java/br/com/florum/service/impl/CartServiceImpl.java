package br.com.florum.service.impl;

import br.com.florum.model.Cart;
import br.com.florum.repository.CartRepository;
import br.com.florum.service.ICartService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CartServiceImpl implements ICartService {
    private final CartRepository cartRepository;

    public CartServiceImpl(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public Cart findByUser(Long userId) {
        return this.cartRepository.findCartByUserId(userId);
    }

    @Override
    public Cart save(Cart cart){
        return this.cartRepository.save(cart);
    }

    @Override
    public void delete(Long id){
        this.cartRepository.deleteById(id);
    }
}

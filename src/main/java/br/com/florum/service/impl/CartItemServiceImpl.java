package br.com.florum.service.impl;

import br.com.florum.dto.cart.CartItemDTO;
import br.com.florum.model.CartItem;
import br.com.florum.repository.CartItemRepository;
import br.com.florum.service.ICartItemService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CartItemServiceImpl implements ICartItemService {
    private final CartItemRepository cartItemRepository;

    public CartItemServiceImpl(CartItemRepository cartItemRepository) {
        this.cartItemRepository = cartItemRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public CartItem findById(Long id) {
        return this.cartItemRepository.findCartItemById(id);
    }

    @Override
    public CartItem save(List<CartItemDTO> items) {
        return null;
    }

//    @Override
//    public CartItem save(CartItem cartItem) {
//        return this.cartItemRepository.save(cartItem);
//    }

    @Override
    public void deleteById(Long id) {
        this.cartItemRepository.deleteById(id);
    }

    @Override
    public Integer countsByUserId(Long cartId) {
        return cartItemRepository.countCartItemsByCartUserId(cartId);
    }

}

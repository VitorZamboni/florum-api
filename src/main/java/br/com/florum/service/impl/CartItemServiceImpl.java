package br.com.florum.service.impl;

import br.com.florum.dto.cart.UpdateCartItemDTO;
import br.com.florum.error.exceptions.NotFoundException;
import br.com.florum.model.CartItem;
import br.com.florum.repository.CartItemRepository;
import br.com.florum.service.ICartItemService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CartItemServiceImpl implements ICartItemService {
    private final CartItemRepository cartItemRepository;

    public CartItemServiceImpl(CartItemRepository cartItemRepository) {
        this.cartItemRepository = cartItemRepository;
    }

    @Override
    @Transactional
    public void updateCartItem(Long id, UpdateCartItemDTO cartItem, Long userId) {
        CartItem item = this.cartItemRepository.findCartItemByIdAndCartUserId(id, userId);
        if (item == null) {
            throw new NotFoundException("Cart item not found with id: " + id);
        }

        item.setQuantity(cartItem.getQuantity());
    }

    @Override
    public void deleteById(Long id, Long userId) {
        CartItem item = this.cartItemRepository.findCartItemByIdAndCartUserId(id, userId);
        if (item == null) {
            throw new NotFoundException("Cart item not found with id: " + id);

        }
        this.cartItemRepository.delete(item);
    }

    @Override
    public Integer countsByUserId(Long cartId) {
        return cartItemRepository.countCartItemsByCartUserId(cartId);
    }

}

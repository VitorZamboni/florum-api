package br.com.florum.repository;

import br.com.florum.model.Cart;
import br.com.florum.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    CartItem findCartItemById(Long id);
    int countCartItemsByCartId(Long cartId);
}

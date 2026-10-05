package br.com.florum.repository;

import br.com.florum.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    CartItem findCartItemById(Long id);
    int countCartItemsByCartUserId(Long userId);
}

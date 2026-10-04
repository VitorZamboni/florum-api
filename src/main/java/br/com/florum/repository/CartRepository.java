package br.com.florum.repository;

import br.com.florum.model.Cart;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository <Cart, Long> {
    @EntityGraph(attributePaths = {"cartItems"})
    Cart findCartByUserId(Long userid);
}

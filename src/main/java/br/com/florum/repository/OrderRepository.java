package br.com.florum.repository;

import br.com.florum.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    Order findOrderByIdAndUserId(Long id, Long userId);

    List<Order> findByUserId(Long userId);
}

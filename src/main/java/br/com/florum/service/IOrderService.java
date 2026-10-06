package br.com.florum.service;

import br.com.florum.dto.order.CreateOrderDTO;
import br.com.florum.model.Order;
import br.com.florum.model.User;

import java.util.List;

public interface IOrderService {
    Long save(CreateOrderDTO orderDTO, User user);
    List<Order> findAll(Long userId);
    Order findById(Long id, Long userId);
}

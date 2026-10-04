package br.com.florum.service;

import br.com.florum.model.Order;

import java.util.List;

public interface IOrderService {
    Order save(Order order);
    List<Order> findAll(Long userId);
    Order findById(Long id);
}

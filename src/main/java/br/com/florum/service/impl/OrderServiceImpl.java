package br.com.florum.service.impl;

import br.com.florum.model.Order;
import br.com.florum.repository.OrderRepository;
import br.com.florum.service.IOrderService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class OrderServiceImpl implements IOrderService {
    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order save(Order order) {
        return this.orderRepository.save(order);
    }

    @Override
    public List<Order> findAll(Long userId) {
        return this.orderRepository.findByUserId(userId);
    }

    @Override
    public Order findById(Long id) {
        Order order = this.orderRepository.findOrderById(id);

        if(order == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Order not found!");
        }

        return order;
    }
}

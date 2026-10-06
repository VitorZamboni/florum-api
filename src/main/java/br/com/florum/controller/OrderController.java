package br.com.florum.controller;

import br.com.florum.dto.order.CreateOrderDTO;
import br.com.florum.dto.order.CreateOrderResponseDTO;
import br.com.florum.dto.order.OrderDTO;
import br.com.florum.mapper.OrderMapper;
import br.com.florum.model.Order;
import br.com.florum.model.User;
import br.com.florum.service.IOrderService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@RestController
@RequestMapping("orders")
public class OrderController {
    private final IOrderService orderService;
    private final OrderMapper orderMapper;

    public OrderController(IOrderService orderService, OrderMapper orderMapper) {
        this.orderService = orderService;
        this.orderMapper = orderMapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateOrderResponseDTO saveOrder(
        @RequestBody @Valid CreateOrderDTO order,
        @AuthenticationPrincipal User user
    ) {
        return new CreateOrderResponseDTO(orderService.save(order, user));
    }

    @GetMapping("user/{userId}")
    public ResponseEntity<List<OrderDTO>> findAllByUser(@PathVariable Long userId){
        return ResponseEntity.status(HttpStatus.OK).body(orderService.findAll(userId).stream().map(orderMapper::toDto).toList());
    }

    @GetMapping("{id}")
    public ResponseEntity<Order> findById(@PathVariable Long id){
        Order order = this.orderService.findById(id);

        if(order == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Order not found!");
        }

        return ResponseEntity.status(HttpStatus.OK).body(order);
    }
}



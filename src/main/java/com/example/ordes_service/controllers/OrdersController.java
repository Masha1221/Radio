package com.example.ordes_service.controllers;

import com.example.ordes_service.DTOs.OrderDto;
import com.example.ordes_service.services.OrdersService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@RestController
public class OrdersController {

    private final OrdersService orderService;

    @PostMapping("/users/orders/create")
    public void createOrderForUser(@RequestBody OrderDto orderDto) {
        orderService.createOrder(orderDto);
        log.info("Order {} - is created", orderDto);
    }

    @PutMapping("/users/{userId}/orders/{orderId}")
    public void updateStatusOrderByUserId(@RequestBody OrderDto orderDto,
                                          @PathVariable Integer userId,
                                          @PathVariable Integer orderId) {
        orderService.updateOrderStatusByUserId(orderDto, orderId, userId);
        log.info("New order status - {} ", orderDto.getStatus());
    }

    @GetMapping("/users/{id}/orders")
    public List<OrderDto> getAllOrdersByUserId(@PathVariable(value = "id") Integer userId) {
        return orderService.getAllOrdersByUserId(userId);
    }

    @GetMapping("/orders")
    public List<OrderDto> getAllOrders() {
        return orderService.getAllOrders();
    }
}

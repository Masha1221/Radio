package com.example.ordes_service.services;

import com.example.ordes_service.DTOs.OrderDto;
import com.example.ordes_service.entities.OrderEntity;
import com.example.ordes_service.repositories.OrdersRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrdersService {

    private final OrdersRepository ordersRepository;

    public OrdersService(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    public OrderEntity convertDtoToEntity(OrderDto orderDto) {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setName(orderDto.getName());
        orderEntity.setStatus(orderDto.getStatus());
        orderEntity.setUserId(orderDto.getUserId());
        return orderEntity;
    }

    public List<OrderDto> getAllOrdersByUserId(Integer userId) {
        return ordersRepository.findOrderEntitiesByUserId(userId)
                .stream()
                .map(orderEntity -> new OrderDto(orderEntity.getId(), orderEntity.getName()
                        , orderEntity.getStatus(), orderEntity.getUserId()))
                .collect(Collectors.toList());
    }

    public void updateOrderStatusForUser(OrderDto orderDto, Integer orderId, Integer userId) {
        OrderEntity order = ordersRepository.findOrderEntityByIdAndUserId(orderId, userId);
        if (order != null) {
            order.setStatus(orderDto.getStatus());
            ordersRepository.save(order);
            orderDto.setName(order.getName());
            orderDto.setUserId(userId);
        } else throw new RuntimeException("Failed to find order by order id or user id.");
    }

    public void createOrder(OrderDto orderDto) {
        OrderEntity orderEntity = convertDtoToEntity(orderDto);
        ordersRepository.save(orderEntity);
    }

    public List<OrderDto> getAllOrders() {
        return ordersRepository.findAll()
                .stream()
                .map(orderEntity -> new OrderDto(orderEntity.getId(), orderEntity.getName()
                        , orderEntity.getStatus(), orderEntity.getUserId()))
                .collect(Collectors.toList());
    }
}

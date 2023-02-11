package com.example.ordes_service.repositories;

import com.example.ordes_service.entities.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersRepository extends JpaRepository<OrderEntity, Integer> {

    List<OrderEntity> findOrderEntitiesByUserId(Integer userId);
}

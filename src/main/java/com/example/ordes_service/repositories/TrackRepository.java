package com.example.ordes_service.repositories;

import com.example.ordes_service.entities.TrackEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrackRepository extends JpaRepository<TrackEntity, Integer> {

    List<TrackEntity> findOrderEntitiesByUserId(Integer userId);
    TrackEntity findOrderEntityByIdAndUserId(Integer orderId, Integer userId);
}

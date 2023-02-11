package com.example.ordes_service.entities;

import com.example.ordes_service.enums.OrderStatus;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Accessors(chain = true)
@Data
@Table(name = "orders")
public class OrderEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "userId")
    private int userId;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private OrderStatus status;
}

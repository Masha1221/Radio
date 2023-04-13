package com.example.ordes_service.entities;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity
@Accessors(chain = true)
@Data
@Table(name = "artists")
public class ArtistEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;

    @Column(name = "name")
    String name;


}

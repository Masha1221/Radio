package com.example.ordes_service.entities;


import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Accessors(chain = true)
@Data
@Table(name = "tracks")
public class TrackEntity  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "artists")
    private List<ArtistEntity> artists;
}

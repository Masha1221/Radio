package com.example.ordes_service.DTOs;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrackDTO {

    private int id;
    private String name;
    private String artist;
}

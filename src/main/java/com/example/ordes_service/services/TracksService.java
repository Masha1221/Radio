package com.example.ordes_service.services;

import com.example.ordes_service.DTOs.TrackDTO;
import com.example.ordes_service.entities.TrackEntity;
import com.example.ordes_service.repositories.TrackRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TracksService {

    private final TrackRepository trackRepository;

    public TracksService(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }


}

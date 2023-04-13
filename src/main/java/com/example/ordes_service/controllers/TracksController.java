package com.example.ordes_service.controllers;

import com.example.ordes_service.DTOs.TrackDTO;
import com.example.ordes_service.services.TracksService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@RestController
public class TracksController {

    private final TracksService orderService;


    @PostMapping("https://accounts.spotify.com/ru/api/tokengra" +
            "nt_type=authorization_code&code=AQAkhUYinsOQ_v0Lr68_0PcQLmXgCsxvYW4v" +
            "5CN7d2F05K0ObvuS0ZVSHjw10WIddYLB-twWxQy5Go63ngdc4pgGTJ9FWJYznCL-Hfs5wF4mzsWyvTHnyp" +
            "wUICDo8ZSffX8B2ichvpc0ErHYuSfa1CpM3BayvEieknb_Nx8v1fhpqokVh8aVPNGd-bHt99eygnOtVzV2AjuL9c" +
            "0UA4Ns0BM&redirect_uri=https://thebattle.club/ru&client_id=ba5" +
            "705def01343428759d159387262d7&client_secret=3b4dc099702c41ee8e93495de900e07d")
    public void  getAllOrdersByUserId() {

    }


    /*@GetMapping("/orders")
    public List<TrackDTO> getAllOrders() {

    }*/
}

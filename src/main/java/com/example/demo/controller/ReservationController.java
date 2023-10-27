package com.example.demo.controller;

import com.example.demo.domain.Reservation;
import com.example.demo.domain.ReservationStatus;
import com.example.demo.dto.ReservationDto;
import com.example.demo.service.ReservationService;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService service;

    @PostMapping("/reservation")
    public ResponseEntity<?> reserveRoom(@RequestBody ReservationDto dto) {

        System.out.println("dto = " + dto);
        
        Reservation reservation = ReservationDto.toEntity(dto);
        reservation.setId(null);
        reservation.setStatus(ReservationStatus.WAITING);

        List<Reservation> reservations = service.reserve(reservation);
        List<ReservationDto> dtos = reservations.stream().map(ReservationDto::new).collect(Collectors.toList());

        return ResponseEntity.ok().body(dtos);
    }

    @GetMapping("/reservation")
    public ResponseEntity<?> retrieveReservations() {

        List<Reservation> entities = service.retrieve();

        List<ReservationDto> dtos = entities.stream().map(ReservationDto::new).collect(Collectors.toList());

        return ResponseEntity.ok().body(dtos);
    }

}

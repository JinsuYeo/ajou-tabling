package com.example.demo.controller;

import com.example.demo.domain.Reservation;
import com.example.demo.domain.ReservationStatus;
import com.example.demo.dto.ReservationDto;
import com.example.demo.dto.ReservationStatusDto;
import com.example.demo.service.ReservationService;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("reservation")
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService service;

    @PostMapping
    public ResponseEntity<?> reserveRoom(@RequestBody ReservationDto dto) {

        System.out.println("dto = " + dto);
        
        Reservation reservation = ReservationDto.toEntity(dto);
        reservation.setStatus(ReservationStatus.WAITING);

        List<Reservation> reservations = service.reserve(reservation);
        List<ReservationDto> dtos = reservations.stream().map(ReservationDto::new).collect(Collectors.toList());

        return ResponseEntity.ok().body(dtos);
    }

    @GetMapping
    public ResponseEntity<?> retrieveReservations() {

        List<Reservation> entities = service.retrieve();

        List<ReservationDto> dtos = entities.stream().map(ReservationDto::new).collect(Collectors.toList());

        return ResponseEntity.ok().body(dtos);
    }

    @GetMapping("/pendiing")
    public ResponseEntity<?> retrievePendingReservation() {
        List<Reservation> entities = service.retrievePending();

        List<ReservationDto> dtos = entities.stream().map(ReservationDto::new).collect(Collectors.toList());

        return ResponseEntity.ok().body(dtos);
    }

    @GetMapping("/ok")
    public ResponseEntity<?> retrieveOkReservation() {
        List<Reservation> entities = service.retrieveApproval();

        List<ReservationDto> dtos = entities.stream().map(ReservationDto::new).collect(Collectors.toList());

        return ResponseEntity.ok().body(dtos);
    }

    @GetMapping("/false")
    public ResponseEntity<?> retrieveFalseReservation() {
        List<Reservation> entities = service.retrieveRefuse();

        List<ReservationDto> dtos = entities.stream().map(ReservationDto::new).collect(Collectors.toList());

        return ResponseEntity.ok().body(dtos);
    }

    @PostMapping("/status")
    public ResponseEntity<?> updateReservation(@RequestBody ReservationDto dto) {

        System.out.println(dto);

        Reservation reservation = ReservationDto.toEntity(dto);
        reservation.setId(Long.parseLong(dto.getId()));

        System.out.println(reservation);

        List<Reservation> entities = service.update(reservation);

        List<ReservationDto> dtos = entities.stream().map(ReservationDto::new).collect(Collectors.toList());

        return ResponseEntity.ok().body(dtos);
    }
}

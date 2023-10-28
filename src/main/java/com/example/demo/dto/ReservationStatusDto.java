package com.example.demo.dto;

import com.example.demo.domain.Reservation;
import com.example.demo.domain.ReservationStatus;
import lombok.Data;
import lombok.Getter;

@Getter
public class ReservationStatusDto {

    private Long id;
    private int status;

    public static Reservation toEntity(final ReservationStatusDto dto) {
        return Reservation.builder()
                .id(dto.getId())
                .status(ReservationStatus.values()[dto.getStatus()])
                .build();
    }
}

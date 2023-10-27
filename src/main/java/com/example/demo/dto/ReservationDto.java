package com.example.demo.dto;

import com.example.demo.domain.Reservation;
import com.example.demo.domain.ReservationStatus;
import com.example.demo.domain.User;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ReservationDto {

    private String date;
    private String startTime;
    private String endTime;
    private String number;
    @Enumerated(EnumType.ORDINAL)
    private int status;

    public ReservationDto(final Reservation reservation) {
        this.date = reservation.getDate();
        this.startTime = reservation.getStartAt();
        this.endTime = reservation.getEndAt();
        this.number = reservation.getNumber();
        this.status = reservation.getStatus().getValue();
    }

    public static Reservation toEntity(final ReservationDto dto) {
        return Reservation.builder()
                .date(dto.getDate())
                .startAt(dto.getStartTime())
                .endAt(dto.getEndTime())
                .number(dto.getNumber())
                .status(ReservationStatus.values()[dto.getStatus()])
                .build();
    }
}

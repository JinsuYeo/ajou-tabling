package com.example.demo.domain;

import com.example.demo.dto.ReservationDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Reservation {

    @Id
    @GeneratedValue
    @Column(name = "reservation_id")
    private Long id;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id")
//    private User user;

    @NotNull
    private String date;

    @NotNull
    @Enumerated(EnumType.ORDINAL)
    private ReservationStatus status;

    @NotNull
    @Column(name = "start_at", length = 100)
    private String startAt;

    @NotNull
    @Column(name = "end_at", length = 100)
    private String endAt;

    @NotNull
    private String number;

//    // 연관관계 메서드
//    public void setUser(User user) {
//        this.user = user;
//        user.getReservations().add(this);
//    }
}

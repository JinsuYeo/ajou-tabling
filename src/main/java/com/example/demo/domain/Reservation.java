package com.example.demo.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Entity
@Getter
public class Reservation {

    @Id
    @GeneratedValue
    @Column(name = "reservation_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @NotNull
    private int status;

    @NotNull
    @Column(name = "start_at", length = 100)
    private String startAt;

    @NotNull
    @Column(name = "end_at", length = 100)
    private String end_et;
}

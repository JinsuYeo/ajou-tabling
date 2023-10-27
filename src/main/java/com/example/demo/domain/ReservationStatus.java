package com.example.demo.domain;

public enum ReservationStatus {
    WAITING(0), APPROVAL(1), REFUSE(2);

    private final int value;

    ReservationStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

package com.example.demo.service;

import com.example.demo.domain.Reservation;
import com.example.demo.domain.ReservationStatus;
import com.example.demo.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationRepository reservationRepository;

    @Transactional
    public List<Reservation> reserve(Reservation reservation) {

        validateReservation(reservation);

        reservation.setId(null);

        System.out.println("reservation = " + reservation);
        
        reservationRepository.save(reservation);

//        return reservationRepository.findByUserId(reservation.getUser().getId());
        return reservationRepository.findAll();
    }

    private static void validateReservation(Reservation reservation) {
        if (reservation == null) throw new IllegalStateException("Reservation connot be null");
//        if (reservation.getUser() == null) throw new IllegalStateException("Unknown user.");
    }

    public List<Reservation> retrieve() {
        return reservationRepository.findAll();
    }

    public List<Reservation> retrievePending() {
        return reservationRepository.findByStatus(ReservationStatus.WAITING);
    }

    public List<Reservation> retrieveApproval() {
        return reservationRepository.findByStatus(ReservationStatus.APPROVAL);
    }

    public List<Reservation> retrieveRefuse() {
        return reservationRepository.findByStatus(ReservationStatus.REFUSE);
    }

    @Transactional
    public List<Reservation> update(final Reservation reservation) {
        validateReservation(reservation);

        System.out.println("reservation.getStatus() = " + reservation.getStatus());
        
        Optional<Reservation> original = reservationRepository.findById(reservation.getId());
        original.ifPresent(res -> {
            res.setStatus(reservation.getStatus());

            reservationRepository.save(res);
        });

        return retrieve();
    }
}

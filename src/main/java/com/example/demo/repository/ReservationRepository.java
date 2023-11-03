package com.example.demo.repository;

import com.example.demo.domain.Reservation;
import com.example.demo.domain.ReservationStatus;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

//    public List<Reservation> findByUserId(Long userId);

    public List<Reservation> findByStatus(ReservationStatus status);
}

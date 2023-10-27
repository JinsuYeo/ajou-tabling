package com.example.demo.repository;

import com.example.demo.domain.Reservation;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ReservationRepository {

    private final EntityManager em;

    public Long save(Reservation reservation) {

        em.persist(reservation);
        return reservation.getId();
    }

    public Optional<Reservation> findOne(Long id) {

        return Optional.of(em.find(Reservation.class, id));
    }

    public List<Reservation> findAll() {

        return em.createQuery("select r from Reservation r", Reservation.class)
                .getResultList();
    }

    public List<Reservation> findByUserId(Long userId) {

        return em.createQuery("select r from Reservation r join r.user u where u.id = :id")
                .setParameter("id", userId)
                .getResultList();
    }
}

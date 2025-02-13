package com.icc.reservations_springboot.service;

import com.icc.reservations_springboot.model.Reservation;
import com.icc.reservations_springboot.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository repository;

    public List<Reservation> getAllReservations() {
        List<Reservation> reservations = new ArrayList<>();
        repository.findAll().forEach(reservations::add);
        return reservations;
    }

    public Reservation getReservation(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void addReservation(Reservation reservation) {
        repository.save(reservation);
    }

    public void updateReservation(Long id, Reservation reservation) {
        repository.save(reservation);
    }

    public void deleteReservation(Long id) {
        repository.deleteById(id);
    }
}

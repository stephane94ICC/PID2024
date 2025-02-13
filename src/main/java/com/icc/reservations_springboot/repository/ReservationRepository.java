package com.icc.reservations_springboot.repository;

import com.icc.reservations_springboot.model.Reservation;
import org.springframework.data.repository.CrudRepository;


public interface ReservationRepository extends CrudRepository<Reservation, Long> {
    // Implémenter les méthodes de recherche...
}

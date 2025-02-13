package com.icc.reservations_springboot.repository;

import com.icc.reservations_springboot.model.Price;
import org.springframework.data.repository.CrudRepository;

public interface PriceRepository extends CrudRepository<Price, Long> {
    // Implémenter les méthodes de recherche...
}

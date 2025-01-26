package com.icc.reservations_springboot.repository;



import com.icc.reservations_springboot.model.Location;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface LocationRepository extends CrudRepository<Location, Long> {
    Location findByDesignation(String designation);
    Optional<Location> findById(Long id);
}

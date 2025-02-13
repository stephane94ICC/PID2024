package com.icc.reservations_springboot.repository;

import com.icc.reservations_springboot.model.Review;
import org.springframework.data.repository.CrudRepository;

public interface ReviewRepository extends CrudRepository<Review, Long> {
    // Implémenter les méthodes de recherche...
}

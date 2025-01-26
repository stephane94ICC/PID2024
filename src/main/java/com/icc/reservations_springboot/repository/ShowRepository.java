package com.icc.reservations_springboot.repository;

import java.util.List;

import com.icc.reservations_springboot.model.Location;
import com.icc.reservations_springboot.model.Show;
import org.springframework.data.repository.CrudRepository;

public interface ShowRepository extends CrudRepository<Show, Long> {
    Show findBySlug(String slug);
    Show findByTitle(String title);
    List<Show> findByLocation(Location location);
}

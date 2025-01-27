package com.icc.reservations_springboot.repository;

import java.time.LocalDateTime;
import java.util.List;

import com.icc.reservations_springboot.model.Location;
import com.icc.reservations_springboot.model.Representation;
import com.icc.reservations_springboot.model.Show;
import org.springframework.data.repository.CrudRepository;

public interface RepresentationRepository extends CrudRepository<Representation, Long> {
    List<Representation> findByShow(Show show);
    List<Representation> findByLocation(Location location);
    List<Representation> findByWhen(LocalDateTime when);
}

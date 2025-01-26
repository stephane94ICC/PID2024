package com.icc.reservations_springboot.repository;



import com.icc.reservations_springboot.model.Locality;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


import org.springframework.data.repository.CrudRepository;

public interface LocalityRepository extends CrudRepository<Locality, Long> {
    Locality findByPostalCode(String postalCode);
    Locality findByLocality(String locality);
}

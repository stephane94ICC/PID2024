package com.icc.reservations_springboot.repository;

import com.icc.reservations_springboot.model.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.List;



import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Long> {
    Role findByRole(String role);
}

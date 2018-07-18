package com.example.demo.repository;

import com.example.demo.model.SecurityRole;
import org.springframework.data.repository.CrudRepository;

public interface SecurityRoleRepository extends CrudRepository<SecurityRole, Integer> {

    SecurityRole findByRole(String role);
}

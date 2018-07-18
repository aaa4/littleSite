package com.example.demo.repository;


import com.example.demo.model.SecurityAccount;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SecurityAccountRepository extends CrudRepository<SecurityAccount, Integer> {

    List<SecurityAccount> findAll();
    SecurityAccount findByUsername(String username);
    void deleteById(int id);

}

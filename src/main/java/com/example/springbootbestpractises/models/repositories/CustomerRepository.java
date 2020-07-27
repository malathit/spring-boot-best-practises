package com.example.springbootbestpractises.models.repositories;

import com.example.springbootbestpractises.models.Customer;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, String> {

  Optional<Customer> findByUsername(String username);
}

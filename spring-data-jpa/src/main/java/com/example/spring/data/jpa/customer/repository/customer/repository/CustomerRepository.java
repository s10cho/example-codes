package com.example.spring.data.jpa.customer.repository.customer.repository;

import java.util.List;

import com.example.spring.data.jpa.customer.repository.customer.domain.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByLastName(String lastName);

    Customer findById(long id);
}

package com.mechanicproject.repository;

import com.mechanicproject.entity.Car;
import com.mechanicproject.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    Customer findByUsername(String customer);
    Customer getById(Integer id);

}

package com.mechanicproject.repository;

import com.mechanicproject.entity.Car;
import com.mechanicproject.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {
    public List<Car> getCarsByCustomer(Customer customer);
}

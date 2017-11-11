package com.mechanicproject.service;

import com.mechanicproject.entity.Car;
import com.mechanicproject.entity.Customer;
import com.mechanicproject.repository.CarRepository;
import com.mechanicproject.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void saveCustomerList(List<Customer> customerList){
        customerRepository.save(customerList);
    }

    public List<Car> getAllCars (Integer customerId){
        return customerRepository.getById(customerId).getCarList();
    }

    public Customer getById(Integer customerId){
        return customerRepository.getById(customerId);
    }

    public Customer getByUsername(String userName){
        return customerRepository.findByUsername(userName);
    }

}



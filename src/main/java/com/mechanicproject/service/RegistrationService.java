package com.mechanicproject.service;

import com.mechanicproject.entity.Customer;
import com.mechanicproject.entity.Role;
import com.mechanicproject.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Service;

/**
 * Created by RENT on 2017-11-09.
 */
@Service
public class RegistrationService {
    private CustomerRepository customerRepository;
    private final AuthenticationManager authenticationManager;

    @Autowired
    public RegistrationService(CustomerRepository customerRepository, AuthenticationManager authenticationManager) {
        this.customerRepository = customerRepository;
        this.authenticationManager = authenticationManager;
    }

    private boolean isUsernameTaken(String username){
        return customerRepository.findByUsername(username) != null;
    }

    public boolean register(String username, String password, String name, String surname) {
        if(!isUsernameTaken(username)) {
            Customer customer = new Customer();
            customer.setPassword(password);
            customer.setUsername(username);
            customer.setName(name);
            customer.setSurname(surname);
            Role role = new Role();
            role.setName("USER");
            customer.getRoleSet().add(role);
            customerRepository.save(customer);
            return true;
        }
        else {
            return false;
        }
    }

    public void saveCustomer(Customer customer) {
        customerRepository.save(customer);
    }

}

package com.mechanicproject.service;

import com.mechanicproject.entity.Customer;
import com.mechanicproject.entity.Privilege;
import com.mechanicproject.repository.CustomerRepository;
import com.mechanicproject.security.Role;
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
    private PrivilegeService privilegeService;

    @Autowired
    public RegistrationService(CustomerRepository customerRepository, AuthenticationManager authenticationManager, PrivilegeService privilegeService) {
        this.customerRepository = customerRepository;
        this.authenticationManager = authenticationManager;
        this.privilegeService = privilegeService;
    }

    private boolean isUsernameTaken(String username){
        return customerRepository.findByUsername(username) != null;
    }

    public boolean register(String username, String password, String name, String surname, String phoneNumber) {
        if(!isUsernameTaken(username)) {
            Customer customer = new Customer();
            customer.setPassword(password);
            customer.setUsername(username);
            customer.setName(name);
            customer.setSurname(surname);
            customer.setPhoneNumber(phoneNumber);
            Privilege role = new Privilege(Role.ROLE_ADMIN);
            Privilege role2 = new Privilege(Role.ROLE_USER);
            customer.getRoleSet().add(role);
            customer.getRoleSet().add(role2);
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

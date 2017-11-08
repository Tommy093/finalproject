package com.mechanicproject.service;

import com.mechanicproject.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Created by RENT on 2017-11-07.
 */
public class CustomerDetailsServiceImpl implements UserDetailsService {
    private CustomerRepository customerRepository;

    @Autowired
    public CustomerDetailsServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String customer) throws UsernameNotFoundException {
        return customerRepository.findByUsername(customer);
    }
}


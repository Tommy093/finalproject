package com.mechanicproject.controller;

import com.mechanicproject.entity.Customer;
import com.mechanicproject.security.Role;
import com.mechanicproject.service.CustomerService;
import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

	CustomerService customerService;

	@Autowired
	public CustomAuthenticationProvider(CustomerService customerService) {
		this.customerService = customerService;
	}

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String name = authentication.getName();
        String password = authentication.getCredentials().toString();
        
        System.out.print("Name = " + name + " ,Password = " + password);
        

		System.out.print("Succesful authentication!");
		Customer customer = customerService.getById(1);
		Set<Role> roleSet = new HashSet<Role>();
		List<SimpleGrantedAuthority> roles = roleSet.stream().map(p -> new SimpleGrantedAuthority(p.name())).collect(Collectors.toList());

		return new UsernamePasswordAuthenticationToken(name, password, customer.getRoleSet());

	}
 
	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
 
}
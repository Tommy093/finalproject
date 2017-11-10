package com.mechanicproject.controller;

import com.mechanicproject.entity.Customer;
import com.mechanicproject.entity.Role;
import com.mechanicproject.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by RENT on 2017-11-09.
 */
@Controller
public class RegistrationController {
    private RegistrationService registrationService;

    @Autowired
    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @Value("${welcome.message:test}")
    private String message = "Hello World";

    @RequestMapping("/registration")
    public String welcome(Map<String, Object> model) {
        model.put("message", this.message);
        String variable = "Jeste Mechanikiem";
        model.put("name", variable);
        return "registration";
    }

    @RequestMapping(value = "/registered", method = RequestMethod.POST)
    public RedirectView addCustomer(@RequestParam(name = "name") String name,
                                    @RequestParam(name = "surname") String surname,
                                    @RequestParam(name = "username") String username,
                                    @RequestParam(name = "password") String password,
                                    @RequestParam(name = "phoneNumber") String phoneNumber) {
        Customer customer = new Customer(name, surname, username, password, phoneNumber);
        Set<Role> roleSet = new HashSet<Role>();
        Role role = new Role();
        role.setId(1);
        role.setName("USER");
        roleSet.add(role);
        customer.setRoleSet(roleSet);
        registrationService.saveCustomer(customer);
        return new RedirectView("/registration");

    }

}




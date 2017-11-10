package com.mechanicproject.controller;

import com.mechanicproject.service.CarService;
import com.mechanicproject.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class UserController {


    private CarService carService;
    private CustomerService customerService;

    @Autowired
    public UserController(CarService carService, CustomerService customerService) {
        this.carService = carService;
        this.customerService = customerService;
    }

    @Value("${welcome.message:test}")
    private String message = "Hello World";

    @RequestMapping("/user")
    public String welcome(Map<String, Object> model) {
        model.put("message", this.message);
        String variable = "Jeste Mechanikiem";
        model.put("name", variable);
        return "user";
    }

//    @RequestMapping(value = "/user", method = RequestMethod.POST)
//    public ModelAndView showUserCars



}


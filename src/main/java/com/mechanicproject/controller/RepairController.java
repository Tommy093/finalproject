package com.mechanicproject.controller;


import com.mechanicproject.entity.Car;
import com.mechanicproject.service.CarService;
import com.mechanicproject.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Map;

@Controller
public class RepairController {

    private CarService carService;
    private CustomerService customerService;

    @Autowired
    public RepairController(CarService carService, CustomerService customerService) {
        this.carService = carService;
        this.customerService = customerService;
    }

    @Value("${welcome.message:test}")
    private String message = "Dodaj samochód";

    @RequestMapping("/addrepair")
    public String welcome(Map<String, Object> model) {
        model.put("message", this.message);
        String variable = "Będzie Pan zadowolony";
        model.put("name", variable);
        return "addrepair";
    }


    @RequestMapping(value = "/repair", method = RequestMethod.POST)
    public RedirectView add(@RequestParam(name = "company") String company, @RequestParam(name = "model")
            String carModel,
                            @RequestParam(name = "yearOfProduction") int yearOfProduction, @RequestParam(name = "registrationNumber")
                                    String registrationNumber) {

        Car car = new Car(company, carModel, yearOfProduction, registrationNumber);
        carService.saveCar(car);
        return new RedirectView("/addrepair");
    }

    @RequestMapping(value = "/addedRepair", method = RequestMethod.GET)
    public RedirectView addedRepair(@RequestParam(name = "company") String company, @RequestParam(name = "model")
            String carModel,
                                    @RequestParam(name = "yearOfProduction") int yearOfProduction, @RequestParam
                                            (name = "registrationNumber")
                                            String registrationNumber) {

        Car car = new Car(company, carModel, yearOfProduction, registrationNumber);
        customerService.getAllCars(1);
        return new RedirectView("/addedrepair");
    }
}


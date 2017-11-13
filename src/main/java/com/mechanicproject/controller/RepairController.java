package com.mechanicproject.controller;


import com.mechanicproject.entity.Car;
import com.mechanicproject.entity.Customer;
import com.mechanicproject.service.CarService;
import com.mechanicproject.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
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
    public ModelAndView add(@RequestParam(name = "company") String company, @RequestParam(name = "model")
            String carModel,
                            @RequestParam(name = "yearOfProduction") int yearOfProduction, @RequestParam
                                    (name = "registrationNumber")
                                    String registrationNumber) {

        Customer customer = customerService.getById(1);
        Car car = new Car(company, carModel, yearOfProduction, registrationNumber, customer);
        carService.saveCar(car);
        ModelAndView modelAndView = new ModelAndView("addedrepair");
        List<Car> carList = carService.getCarsByCustomer(customer);
        modelAndView.addObject("carList", carList);

        return modelAndView;
    }
}


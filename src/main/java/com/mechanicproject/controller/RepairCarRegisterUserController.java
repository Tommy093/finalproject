package com.mechanicproject.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class RepairCarRegisterUserController {
    @Value("${welcome.message:test}")
    private String message = "Dodaj samochód";

    @RequestMapping("/addrepair")
    public String welcome(Map<String, Object> model) {
        model.put("message", this.message);
        String variable = "Będzie Pan zadowolony";
        model.put("name", variable);
        return "addrepair";
    }
}

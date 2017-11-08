package com.mechanicproject.controller;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @Value("${welcome.message:test}")
    private String message = "Hello World";

    @RequestMapping("/home")
    public String welcome(Map<String, Object> model) {
        model.put("message", this.message);
        String variable = "przykładowa zmienna";
        model.put("zmienna", variable);
        return "home";
    }
}

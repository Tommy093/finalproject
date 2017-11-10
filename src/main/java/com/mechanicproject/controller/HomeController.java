package com.mechanicproject.controller;
import java.util.Map;

import org.apache.catalina.Authenticator;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class HomeController {

    private AuthenticationProvider authenticationProvider;

    @Autowired
    public HomeController(AuthenticationProvider authenticationProvider) {
        this.authenticationProvider = authenticationProvider;
    }

    @Value("${welcome.message:test}")
    private String message = "Hello World";

    @RequestMapping("/home")
    public String welcome(Map<String, Object> model) {
        model.put("message", this.message);
        String variable = "przykładowa zmienna";
        model.put("zmienna", variable);
        return "home";
    }

    @RequestMapping("/login")
    public String welcome(@RequestParam(name = "username") String username,
                          @RequestParam(name = "password") String password,
                          HttpServletRequest request) {
        doAutoLogin(username, password, request);
        return "login";
    }

    @RequestMapping("/admin/login")
    public String admin() {
        return "login";
    }

    @RequestMapping("/user/login")
    public String user() {
        return "login";
    }

    private void doAutoLogin(String username, String password, HttpServletRequest request) {

        try {
            // Must be called from request filtered by Spring Security, otherwise SecurityContextHolder is not updated
            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
            token.setDetails(new WebAuthenticationDetails(request));
            Authentication authentication = this.authenticationProvider.authenticate(token);
            SecurityContextHolder.getContext().setAuthentication(authentication);
        } catch (Exception e) {
            SecurityContextHolder.getContext().setAuthentication(null);
        }

    }
}

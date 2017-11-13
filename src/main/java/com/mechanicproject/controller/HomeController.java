package com.mechanicproject.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.mechanicproject.entity.Privilege;
import com.mechanicproject.security.Role;
import org.apache.catalina.Authenticator;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
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
    public ModelAndView welcome(Map<String, Object> model) {

        List<String> collect = SecurityContextHolder.getContext().getAuthentication().getAuthorities().stream().map(a -> a.getAuthority()).collect(Collectors.toList());
        model.put("message", this.message);
        String variable = "przykładowa zmienna";
        model.put("zmienna", variable);
        ModelAndView modelAndView = new ModelAndView("home");
        return modelAndView;
    }

    @RequestMapping("/login")
    public String welcome(@RequestParam(name = "username") String username,
                          @RequestParam(name = "password") String password,
                          HttpServletRequest request) {
        doAutoLogin(username, password, request);
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String welcome2(@RequestParam(name = "username") String username,
                           @RequestParam(name = "password") String password,
                           HttpServletRequest request) {
        doAutoLogin(username, password, request);
        return "login";
    }

    @Secured(value={"ADMIN"})
    @RequestMapping("/admin/login")
    public String admin() {
        return "login";
    }

    @Secured(value={"ROLE_USER"})
    @RequestMapping("/user/login")
    public String user() {
        return "login";
    }

    private void doAutoLogin(String username, String password, HttpServletRequest request) {

        try {
            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
            token.setDetails(new WebAuthenticationDetails(request));
            Authentication authentication = this.authenticationProvider.authenticate(token);
            SecurityContextHolder.getContext().setAuthentication(authentication);
        } catch (Exception e) {
            SecurityContextHolder.getContext().setAuthentication(null);
        }

    }
}

package com.mechanicproject.controller;


import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.mechanicproject.entity.Privilege;
import com.mechanicproject.exceptions.NotFoundCustomer;
import com.mechanicproject.exceptions.WrongPasswordException;
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

        List<String> collect = SecurityContextHolder.getContext().getAuthentication().getAuthorities().stream().map(a ->
                a.getAuthority()).collect(Collectors.toList());
        model.put("message", this.message);
        String variable = "przykładowa zmienna";
        model.put("zmienna", variable);
        ModelAndView modelAndView = new ModelAndView("home");
        if (collect.size() > 0)
            model.put("auth", collect.get(0));
        return modelAndView;
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public RedirectView welcome2(@RequestParam(name = "username") String username,
                           @RequestParam(name = "password") String password,
                           HttpServletRequest request) {

        RedirectView redirect = new RedirectView("home");
        try{
            doAutoLogin(username, password, request);
        }catch(WrongPasswordException e){
            redirect.addStaticAttribute("error", "bledneHaslo");
            return redirect;
        } catch(NotFoundCustomer e){
            redirect.addStaticAttribute("error", "blednyCustomer");
            return redirect;
        }
        return redirect;
    }

    private void doAutoLogin(String username, String password, HttpServletRequest request) throws WrongPasswordException, NotFoundCustomer{

        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
        token.setDetails(new WebAuthenticationDetails(request));
        Authentication authentication = this.authenticationProvider.authenticate(token);

        SecurityContextHolder.getContext().setAuthentication(authentication);


    }

    @RequestMapping("/logout")
    private RedirectView doAutoLogout() {
        SecurityContextHolder.getContext().setAuthentication(null);
        return new RedirectView("home");
    }
}

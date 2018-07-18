package com.example.demo.controller;

import com.example.demo.model.SecurityAccount;
import com.example.demo.services.SecurityAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MySecureController {

    @Autowired
    SecurityAccountService service;
    @Autowired
    PasswordEncoder encoder;

    @GetMapping("/users/all")
    public String getUserList(Model model, HttpServletRequest request){
        model.addAttribute("users", service.findAll());
        model.addAttribute("newUser",   new SecurityAccount().createEmptyInstance());
        model.addAttribute("username",   request.getUserPrincipal().getName());
        model.addAttribute("roles",   new String());
        return "loginPageTemplate";
    }

    @PostMapping("/user/add")
    public String postAddSecurityAccount(@ModelAttribute SecurityAccount newSecAccount){
        String encodedPassword = encoder.encode(newSecAccount.getPassword());
        newSecAccount.setPassword(encodedPassword);
        service.save(newSecAccount);
        return "redirect:/users/all";
    }

    @GetMapping("/user/delete/{id}")
    public String getDeleteSecurityAccount(@PathVariable  String id){
        service.delete(Integer.valueOf(id));
        return "redirect:/users/all";
    }

    @GetMapping("/user/credentials")
    public String getCredentialsPage(HttpServletRequest request, Model model){
        String userName = request.getUserPrincipal().getName();
        model.addAttribute("user", service.findByUsername(userName));
        return "/credentials";
    }

}

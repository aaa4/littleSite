package com.example.demo.controller;


import com.example.demo.model.ArticleContent;
import com.example.demo.repository.ArticleContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;

@Controller

public class PartialController {


    @Autowired
    ArticleContentRepository repository;
    int year = LocalDate.now().getYear();

    @GetMapping("/")
    public String getIndex(HttpServletRequest request, Model model) {
        model.addAttribute("cookies", request.getCookies());

        System.out.println(request);
        System.out.println(request.getRemoteUser());
        for (Cookie c : request.getCookies()) {
            System.out.println(c.getName());
            System.out.println(c.getDomain());
            System.out.println(c.getValue());
            System.out.println(c.getVersion());
            System.out.println(c.getComment());
        }


        System.out.println();
        return "index";
    }

    @GetMapping("/articles")
    public String getHomePage(Model model, HttpServletRequest request) {
        model.addAttribute("articles", repository.findAll());
        model.addAttribute("year", year);
        model.addAttribute("content", new ArticleContent());
        model.addAttribute("req", request);

        if (request != null) {

            System.out.println("HttpServletRequest is "+ request);
            if (request.getUserPrincipal() != null) {
                model.addAttribute("userPrincipal", request.getUserPrincipal());
                System.out.println("user principal is " +request.getUserPrincipal());
                if (request.getUserPrincipal().getName() != null) {
                    System.out.println("name is " +request.getUserPrincipal().getName());
                }else{
                    System.out.println("request.getUserPrincipal().getName() is null");
                }
            }else{
                System.out.println("request.getUserPrincipal() is null");
            }
        } else {
            System.out.println("request is null");

        }
        System.out.println("HttpSession Id is "+request.getSession().getId());
        System.out.println("HttpSession AttributeNames is "+request.getSession().getAttributeNames());
        System.out.println("HttpSession CreationTime is "+request.getSession().getCreationTime());
        System.out.println("HttpSession LastAccessedTime is "+request.getSession().getLastAccessedTime());

      /* if (request.getUserPrincipal() != null)
           model.addAttribute("userName", request.getUserPrincipal().getName());*/
        return "homepage";

    }

    @GetMapping("/a{id}/b{title}")
    public String getUpdateArticle(@PathVariable("id") int id, @PathVariable("title") String title, Model model) {
        model.addAttribute("content", repository.findDistinctById(id));
        System.out.println(repository.findDistinctById(id));
        model.addAttribute("id", id);
        model.addAttribute("year", year);
        return "update";
    }


    @PostMapping("/postHomePage{id}")
    public String postHomePage(@ModelAttribute ArticleContent content, @PathVariable("id") int id) {
        repository.save(content);
        return "redirect:/";
    }


    @GetMapping("/art{id}/delete")
    public String deleteArticle(@PathVariable int id) {
        repository.deleteById(id);
        return "redirect:/";
    }


}

package com.example.demo.controller;


import com.example.demo.model.ArticleContent;
import com.example.demo.repository.ArticleContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
public class PartialController {


    @Autowired
    ArticleContentRepository repository;
    int year = LocalDate.now().getYear();

    @GetMapping("/")
    public String getHomePage(Model model) {
        model.addAttribute("articles", repository.findAll());
        model.addAttribute("year", year);
        model.addAttribute("content", new ArticleContent());
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
    public String postHomePage(@ModelAttribute  ArticleContent content, @PathVariable ("id") int id) {
        repository.save(content);
        return "redirect:/";
    }


    @GetMapping("/formsSkilling")
    public String getFormSkilling(){
        return "formSkilling";
    }

    /*@PostMapping("/update")
    public String getUpdateArticle(@ModelAttribute("content") ArticleContent content) {
        repository.save(content);
        return "redirect:/";
    }*/

    @GetMapping("/art{id}/delete")
    public String deleteArticle(@PathVariable int id) {
        repository.deleteById(id);
        return "redirect:/";
    }




   /* @GetMapping("/2")
    public String getSomething(){
        return "update";
    }*/
}

package com.example.demo.services;

import com.example.demo.model.ArticleContent;
import com.example.demo.repository.ArticleContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleContentService {

    @Autowired
    ArticleContentRepository repository;



    public void saveOrUpdate(ArticleContent articleContent){
        repository.save(articleContent);
    }
}

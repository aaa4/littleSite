package com.example.demo.repository;

import com.example.demo.model.ArticleContent;
import org.springframework.data.repository.CrudRepository;

public interface ArticleContentRepository extends CrudRepository<ArticleContent, Integer> {

    ArticleContent findDistinctByTitle(String title);
    ArticleContent findDistinctById(int id);

}

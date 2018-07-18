package com.example.demo.repository;

import com.example.demo.model.ArticleCategory;
import org.springframework.data.repository.CrudRepository;

public interface ArticleCategoryRepository extends CrudRepository<ArticleCategory, Integer> {
}

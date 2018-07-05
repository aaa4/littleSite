package com.example.demo.repository;

import com.example.demo.model.Category;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Author;
public interface CategoryRepository extends CrudRepository<Category, Integer> {

}
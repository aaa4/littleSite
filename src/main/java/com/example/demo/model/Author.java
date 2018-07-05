package com.example.demo.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<Article> articles;

    public Author() {
    }

    public void addArticle(Article article){
       if (articles  == null)
           articles = new ArrayList<>();
        articles.add(article);
        article.setAuthor(this);
    }




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



}


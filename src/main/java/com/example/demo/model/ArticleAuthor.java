package com.example.demo.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ArticleAuthor {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;

    @OneToMany(mappedBy = "author", orphanRemoval = true, cascade = CascadeType.ALL)
    List<ArticleContent> contentList;


    public ArticleAuthor() {
    }

    public ArticleAuthor(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void addArticleContent(ArticleContent articleContent){
        if (this.contentList == null)
            contentList = new ArrayList<>();
        contentList.add(articleContent);
        articleContent.setAuthor(this);
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

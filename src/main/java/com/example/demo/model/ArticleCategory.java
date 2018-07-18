package com.example.demo.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ArticleCategory {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String tag;

    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL, mappedBy = "category")
    private List<ArticleContent> contentList;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public List<ArticleContent> getContentList() {
        return contentList;
    }

    public void setContentList(List<ArticleContent> contentList) {
        this.contentList = contentList;
    }


    public void addArticleContent(ArticleContent content){
        if (contentList == null)
            contentList = new ArrayList<>();
        contentList.add(content);
        content.setCategory(this);
    }
}

package com.example.demo.model;

import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class ArticleContent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String title;
    String description;
    String content;
    @Column(name = "publication_date")
    LocalDate date;

    @ManyToOne(cascade = CascadeType.ALL)
    private ArticleAuthor author;

    @ManyToOne(cascade = CascadeType.ALL)
    private ArticleCategory category;



    public ArticleContent() {
    }

    public ArticleContent(String title, String description, String content) {
        this.title = title;
        this.description = description;
        this.content = content;
    }

    public ArticleContent(String title, String description, String content, LocalDate date) {
        this.title = title;
        this.description = description;
        this.content = content;
        this.date = date;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public ArticleAuthor getAuthor() {
        return author;
    }

    public void setAuthor(ArticleAuthor author) {
        this.author = author;
    }

    public ArticleCategory getCategory() {
        return category;
    }

    public void setCategory(ArticleCategory category) {
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArticleContent that = (ArticleContent) o;
        return id == that.id;
    }



    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "ArticleContent{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}

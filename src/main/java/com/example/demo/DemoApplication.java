package com.example.demo;

import com.example.demo.model.Article;
import com.example.demo.model.Author;
import com.example.demo.model.Category;
import com.example.demo.repository.ArticleRepository;
import com.example.demo.repository.AuthorRepository;
import com.example.demo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication  implements CommandLineRunner {

    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    ArticleRepository articleRepository;
    @Autowired
    CategoryRepository categoryRepository;
    public static void main(String[] args) {

        SpringApplication.run(DemoApplication.class, args);
    }




    @Override
    public void run(String... args) throws Exception {
        Author author = new Author();
        Article aboutAuthor = new Article("2About Author");
        Article forumRules = new Article("2Forum Rules");
        Category manual = new Category("manual");
        manual.addArticle(aboutAuthor);
        manual.addArticle(forumRules);
        author.addArticle(aboutAuthor);
        author.addArticle(forumRules);
         articleRepository.save(aboutAuthor);
         articleRepository.save(forumRules);

    }
}

package com.example.demo;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication  implements CommandLineRunner {

    @Autowired
    ArticleContentRepository articleContentRepository;

    @Autowired
    ArticleAuthorRepository articleAuthorRepository;

    @Autowired
    ArticleCategoryRepository articleCategoryRepository;

    public static void main(String[] args) {

        SpringApplication.run(DemoApplication.class, args);
    }




    @Override
    public void run(String... args) throws Exception {



       /* ArticleContent c = new ArticleContent();
        c.setTitle("c1");
        c.setContent("new c1 content");
        ArticleAuthor a = new ArticleAuthor();
        a.setName("first writer");
        a.addArticleContent(c);
        ArticleCategory cat = new ArticleCategory();
        cat.setTag("world");
        cat.addArticleContent(c);
        articleAuthorRepository.save(a);
        articleCategoryRepository.save(cat);*/

   /*     ArticleContent a = new ArticleContent();
        a.setTitle("title");
        a.setDescription("description");
        articleContentRepository.save(a);
        ArticleContent b = articleContentRepository.findDistinctByTitle("title");
        b.setTitle("anotherTitle");
        articleContentRepository.save(b);*/

      /*  Author author = new Author();
        Article aboutAuthor = new Article("2About Author");
        Article forumRules = new Article("2Forum Rules");
        Category manual = new Category("manual");
        manual.addArticle(aboutAuthor);
        manual.addArticle(forumRules);
        author.addArticle(aboutAuthor);
        author.addArticle(forumRules);
         articleRepository.save(aboutAuthor);
         articleRepository.save(forumRules);*/

    }
}

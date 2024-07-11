package fr.wildcodeschool.BlogApplication.controllers;

import fr.wildcodeschool.BlogApplication.models.Article;
import fr.wildcodeschool.BlogApplication.repositories.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/articles")
public class ArticleController {
    @Autowired
    private ArticleRepository articleRepository;

    //Methode CRUD
    //Create
    @PostMapping
    public ResponseEntity<Article> addArticle(@RequestBody Article article) {
        article.setCreationDate(LocalDateTime.now());
        Article savedArticle = articleRepository.save(article);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedArticle);
    }
    //ReadALl
    @GetMapping
    public ResponseEntity<List<Article>> getAllArticles() {
        List<Article> articles = articleRepository.findAll();
        if (articles.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok().body(articles);
    }
    //ReadOne
    @GetMapping("/{id}")
    public ResponseEntity<Article> getArticleById(@PathVariable Long id) {
        Article savedArticle = articleRepository.findById(id).orElse(null);
        if (savedArticle == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(savedArticle);
    }
    //ReadByTitle
    @GetMapping("/search-title")
    public ResponseEntity<List<Article>> getArticlesByTitle(@RequestParam String searchTerms) {
        List<Article> articles = articleRepository.findByTitle(searchTerms);
        if (articles.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok().body(articles);
    }
    //ReadByContentContaining
    @GetMapping("/search-stringInContent")
    public ResponseEntity<List<Article>> getArticlesByStringInContent(@RequestParam String searchTerms) {
        List<Article> articles = articleRepository.findByContentContaining(searchTerms);
        if (articles.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok().body(articles);
    }
    //ReadByDateCreation
    @GetMapping("/search-dateCreation")
    public ResponseEntity<List<Article>> getArticlesByDateCreation(@RequestParam LocalDateTime dateCreation) {
        List<Article> articles = articleRepository.findByStartDateAfter(dateCreation);
        if (articles.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok().body(articles);
    }
    //Read 5 top By Order By Date Created Desc
    @GetMapping("/search-fiveLast")
    public ResponseEntity<List<Article>> getArticlesByFiveLast() {
        List<Article> articles = articleRepository.findTop5ByOrderByDateCreatedDesc();
        if (articles.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok().body(articles);
    }
    //Update
    @PutMapping("/{id}")
    public ResponseEntity<Article> updateArticle(@PathVariable Long id, @RequestBody Article articleDetails) {
        Article savedArticle = articleRepository.findById(id).orElse(null);
        if (savedArticle == null) {
            return ResponseEntity.notFound().build();
        }else{
            savedArticle.setTitle(articleDetails.getTitle());
            savedArticle.setContent(articleDetails.getContent());
            savedArticle.setUpdateDate(LocalDateTime.now());
            Article updatedArticle = articleRepository.save(savedArticle);
            return ResponseEntity.ok().body(updatedArticle);
        }
    }
    //Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Article> deleteArticle(@PathVariable Long id) {
        Article article = articleRepository.findById(id).orElse(null);
        if (article == null) {
            return ResponseEntity.notFound().build();
        }
        articleRepository.delete(article);
        return ResponseEntity.noContent().build();
    }

}

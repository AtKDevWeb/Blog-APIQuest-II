package fr.wildcodeschool.BlogApplication.repositories;

import fr.wildcodeschool.BlogApplication.models.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    List<Article> findByTitle(String title);
    List<Article> findByContentContaining(String author);
    List<Article> findByCreationDateAfter(LocalDateTime date);
    List<Article> findTop5ByOrderByCreationDateDesc();

}

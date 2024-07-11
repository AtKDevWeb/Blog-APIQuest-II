package fr.wildcodeschool.BlogApplication.repositories;

import fr.wildcodeschool.BlogApplication.models.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}

package fr.wildcodeschool.BlogApplication.repositories;

import fr.wildcodeschool.BlogApplication.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}

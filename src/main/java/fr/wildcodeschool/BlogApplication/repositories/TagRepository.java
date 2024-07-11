package fr.wildcodeschool.BlogApplication.repositories;

import fr.wildcodeschool.BlogApplication.models.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {
}

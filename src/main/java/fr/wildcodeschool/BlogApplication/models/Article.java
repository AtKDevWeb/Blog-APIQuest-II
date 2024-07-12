package fr.wildcodeschool.BlogApplication.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(columnDefinition = "LONGTEXT")
    private String content;

    @Column(nullable = false, updatable = false)
    private LocalDateTime creationDate;

    private LocalDateTime updateDate;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Article() {
    }
    public Article(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public Article(String title, String content, LocalDateTime creationDate, LocalDateTime updateDate) {
        this.title = title;
        this.content = content;
        this.creationDate = creationDate;
        this.updateDate = updateDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime upDate) {
        this.updateDate = upDate;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}

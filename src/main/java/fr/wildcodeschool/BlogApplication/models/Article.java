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
    @Column(nullable = false)
    private long category_id;

    public Article() {
    }
    public Article(String title, String content, long category_id) {
        this.title = title;
        this.content = content;
        this.category_id = category_id;
    }

    public Article(String title, String content, long category_id, LocalDateTime creationDate, LocalDateTime upDate) {
        this.title = title;
        this.content = content;
        this.category_id = category_id;
        this.creationDate = creationDate;
        this.updateDate = upDate;
    }

    public long getCategory_id() {
        return category_id;
    }

    public void setCategory_id(long category_id) {
        this.category_id = category_id;
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
}

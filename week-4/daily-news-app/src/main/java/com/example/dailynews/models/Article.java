package com.example.dailynews.models;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "articles")
public class Article {
  @Id
  @UuidGenerator
  private String id;

  private String title;

  @Column(columnDefinition="TEXT")
  private String description;

  @ManyToOne
  @JoinColumn(name = "author_id")
  private User author;

  @ManyToOne
  @JoinColumn(name = "article_type_id")
  private ArticleType articleType;

  @CreationTimestamp
  private LocalDateTime createdAt;

  @UpdateTimestamp
  private LocalDateTime updatedAt;

  private Boolean isDeleted = false;
  private Boolean isValid = false;
  private Long viewsCount = 0L;

  public Article(String title, String description, User author, ArticleType articleType) {
    this.title = title;
    this.description = description;
    this.author = author;
    this.articleType = articleType;
  }

}

package com.example.dailynews.models;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "article_comments")
public class CommentArticle {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(columnDefinition = "TEXT")
  private String commentText;
  
  @ManyToOne
  @JoinColumn(name = "article_id")
  private Article article;

  private String commentator;

  @JsonIgnore
  @CreationTimestamp
  private LocalDateTime createdAt;
  
  @JsonIgnore
  @UpdateTimestamp
  private LocalDateTime updatedAt;
  
  @JsonIgnore
  private Boolean isDeleted = false;

  public CommentArticle(String commentText, Article article, String commentator) {
    this.commentText = commentText;
    this.article = article;
    this.commentator = commentator;
  }

}

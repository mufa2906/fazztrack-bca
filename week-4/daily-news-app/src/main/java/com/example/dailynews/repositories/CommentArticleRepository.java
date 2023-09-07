package com.example.dailynews.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.dailynews.models.Article;
import com.example.dailynews.models.CommentArticle;
import java.util.List;


public interface CommentArticleRepository extends JpaRepository<CommentArticle, Long> {
  List<CommentArticle> findByArticle(Article article);
}

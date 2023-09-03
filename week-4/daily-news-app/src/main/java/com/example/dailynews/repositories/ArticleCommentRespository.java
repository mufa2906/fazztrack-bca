package com.example.dailynews.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.dailynews.models.Article;
import com.example.dailynews.models.ArticleComment;
import java.util.List;


public interface ArticleCommentRespository extends JpaRepository<ArticleComment, Long> {
  List<ArticleComment> findByArticle(Article article);
}

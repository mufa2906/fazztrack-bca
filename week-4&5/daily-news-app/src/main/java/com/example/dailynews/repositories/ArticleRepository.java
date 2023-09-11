package com.example.dailynews.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.dailynews.models.Article;


public interface ArticleRepository extends JpaRepository<Article, String>{
  
  // @Query(value = "SELECT * FROM users WHERE username = :usernameOrEmail OR email = :usernameOrEmail ", nativeQuery = true)
  List<Article> findFirst3ByOrderByViewsCountDesc();
  
  List<Article> findTop3ByOrderByLikesCountDesc();

  List<Article> OrderByCreatedAtDesc();

  List<Article> findByIsValidIsTrue();

  List<Article> findByIsDeleted(Boolean isDeleted);
}

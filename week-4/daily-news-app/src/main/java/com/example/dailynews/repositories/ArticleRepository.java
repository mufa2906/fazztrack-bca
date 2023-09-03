package com.example.dailynews.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.dailynews.models.Article;

public interface ArticleRepository extends JpaRepository<Article, String>{
  
}

package com.example.dailynews.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.dailynews.models.ArticleType;

public interface ArticleTypeRepository extends JpaRepository<ArticleType, Long>{
  Boolean existsByArticleTypeIgnoreCase(String articleType);
}

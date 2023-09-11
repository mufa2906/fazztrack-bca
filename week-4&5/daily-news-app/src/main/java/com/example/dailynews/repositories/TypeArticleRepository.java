package com.example.dailynews.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.dailynews.models.TypeArticle;

public interface TypeArticleRepository extends JpaRepository<TypeArticle, Long>{
  Boolean existsByTypeIgnoreCase(String articleType);

  TypeArticle findByTypeIgnoreCase(String articleType);
}

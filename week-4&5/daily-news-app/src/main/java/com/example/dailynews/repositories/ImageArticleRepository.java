package com.example.dailynews.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.dailynews.models.ImageArticle;


public interface ImageArticleRepository extends JpaRepository<ImageArticle, String> {
}

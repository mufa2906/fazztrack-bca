package com.example.dailynews.services.article;

import org.springframework.http.ResponseEntity;

import com.example.dailynews.payloads.req.AddArticleRequest;
import com.example.dailynews.payloads.req.UpdateArticleRequest;

public interface ArticleService {
  ResponseEntity<?> addArticleService(AddArticleRequest request);

  ResponseEntity<?> getArticlesService();

  ResponseEntity<?> updateArticlesService(UpdateArticleRequest request);
  
  ResponseEntity<?> getTrendingArticlesService();

  ResponseEntity<?> getLatestArticlesService();

  ResponseEntity<?> getRecommendedArticlesService();

  ResponseEntity<?> getPopularArticlesService();


}

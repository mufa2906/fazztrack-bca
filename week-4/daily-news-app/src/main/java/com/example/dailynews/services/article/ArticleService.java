package com.example.dailynews.services.article;

import org.springframework.http.ResponseEntity;

import com.example.dailynews.payloads.req.AddArticleRequest;
import com.example.dailynews.payloads.req.UpdateArticleRequest;
import com.example.dailynews.payloads.req.ValidateArticleRequest;

public interface ArticleService {
  ResponseEntity<?> addArticleService(AddArticleRequest request);

  ResponseEntity<?> getArticlesService();

  ResponseEntity<?> updateArticlesService(UpdateArticleRequest request, String id);
  
  ResponseEntity<?> getTrendingArticlesService();

  ResponseEntity<?> getLatestArticlesService();

  ResponseEntity<?> getRecommendedArticlesService();

  ResponseEntity<?> getPopularArticlesService();

  ResponseEntity<?> validityArticlesService(ValidateArticleRequest request, String id);

  ResponseEntity<?> getArticlesByIdService(String id);


}

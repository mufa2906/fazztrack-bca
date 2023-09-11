package com.example.dailynews.services.article;

import org.springframework.http.ResponseEntity;

import com.example.dailynews.payloads.req.article.AddArticleRequest;
import com.example.dailynews.payloads.req.article.UpdateArticleRequest;
import com.example.dailynews.payloads.req.article.ValidateArticleRequest;

public interface ArticleService {
  ResponseEntity<?> addArticleService(AddArticleRequest request);

  ResponseEntity<?> getArticlesService(Boolean isDeleted);

  ResponseEntity<?> updateArticlesService(UpdateArticleRequest request, String id);
  
  ResponseEntity<?> getTrendingArticlesService();

  ResponseEntity<?> getLatestArticlesService();

  ResponseEntity<?> getRecommendedArticlesService();

  ResponseEntity<?> getPopularArticlesService();

  ResponseEntity<?> validityArticlesService(ValidateArticleRequest request, String id);

  ResponseEntity<?> getArticlesByIdService(String id);

  ResponseEntity<?> deleteArticlesByIdService(String id);


}

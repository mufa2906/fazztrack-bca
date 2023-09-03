package com.example.dailynews.services.article;

import org.springframework.http.ResponseEntity;

import com.example.dailynews.payloads.req.AddArticleRequest;

public interface ArticleService {
  ResponseEntity<?> addArticleService(AddArticleRequest request);

  ResponseEntity<?> getArticlesService();
}

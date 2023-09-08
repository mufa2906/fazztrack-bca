package com.example.dailynews.services.articleType;

import org.springframework.http.ResponseEntity;

import com.example.dailynews.payloads.req.article.AddArticleTypeRequest;

public interface ArticleTypeService {
  ResponseEntity<?> addArticleTypeService(AddArticleTypeRequest request);

  ResponseEntity<?> getArticleTypesService();

  ResponseEntity<?> deleteArticleTypeService(String type);
}

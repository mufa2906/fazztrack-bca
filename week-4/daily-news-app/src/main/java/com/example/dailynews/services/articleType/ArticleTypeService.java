package com.example.dailynews.services.articleType;

import org.springframework.http.ResponseEntity;

import com.example.dailynews.payloads.req.AddArticleTypeRequest;

public interface ArticleTypeService {
  ResponseEntity<?> addArticleTypeService(AddArticleTypeRequest request);

  ResponseEntity<?> getArticleTypesService();
}

package com.example.dailynews.services.articleComment;

import org.springframework.http.ResponseEntity;

import com.example.dailynews.payloads.req.AddArticleCommentRequest;

public interface ArticleCommentService {
  ResponseEntity<?> addArticleCommentService(AddArticleCommentRequest request);

  ResponseEntity<?> getArticleCommentsService();
  
  ResponseEntity<?> getArticleCommentsByArticleService(String articleId);

  
}

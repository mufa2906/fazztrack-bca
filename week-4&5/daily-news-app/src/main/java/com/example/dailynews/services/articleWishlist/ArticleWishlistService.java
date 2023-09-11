package com.example.dailynews.services.articleWishlist;

import org.springframework.http.ResponseEntity;

import com.example.dailynews.payloads.req.article.AddArticleWishlistRequest;

public interface ArticleWishlistService {
  ResponseEntity<?> addArticleWishlist(AddArticleWishlistRequest request);

  ResponseEntity<?> getArticleWishlistService();
  
  ResponseEntity<?> getArticleWishlistByUserService(String userId);
}

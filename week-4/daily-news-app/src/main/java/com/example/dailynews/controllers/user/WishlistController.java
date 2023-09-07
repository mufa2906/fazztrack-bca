package com.example.dailynews.controllers.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dailynews.payloads.req.AddArticleWishlistRequest;
import com.example.dailynews.services.articleWishlist.ArticleWishlistService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/article-wishlist")
public class WishlistController {
  @Autowired
  ArticleWishlistService wishlistService;

  @PostMapping("/create")
  public ResponseEntity<?> createArticleWishlist(@RequestBody @Valid AddArticleWishlistRequest request) {
    return wishlistService.addArticleWishlist(request);
  }

  @GetMapping("/{userId}")
  public ResponseEntity<?> getArticleWishlistByUser(@PathVariable String userId) {
    return wishlistService.getArticleWishlistByUserService(userId);
  }

}

package com.example.dailynews.controllers.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.dailynews.configs.JwtUtil;
import com.example.dailynews.payloads.req.article.AddArticleWishlistRequest;
import com.example.dailynews.services.articleWishlist.ArticleWishlistService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/article-wishlist")
public class WishlistController {
  @Autowired
  ArticleWishlistService wishlistService;

  @Autowired
  JwtUtil jwtUtil;

  @PostMapping("/create")
  @PreAuthorize("#request.username == authentication.name")
  public ResponseEntity<?> createArticleWishlist(@RequestBody @Valid AddArticleWishlistRequest request) {
    return wishlistService.addArticleWishlist(request);
  }

  @GetMapping("/user")
  public ResponseEntity<?> getArticleWishlistByUser(@RequestParam(value = "token") String token) {
    //ngambil token username
    String username = jwtUtil.getUsernameFromToken(token);
    return wishlistService.getArticleWishlistByUserService(username);
  }

    @GetMapping("/greeting")
  public ResponseEntity<String> greeting(@RequestHeader(HttpHeaders.AUTHORIZATION) String language) {
    String token = language.substring(7);
    String username = jwtUtil.getUsernameFromToken(token);
    // code that uses the language variable
    return new ResponseEntity<String>(username, HttpStatus.OK);
  }


}

package com.example.dailynews.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.dailynews.payloads.req.AddArticleRequest;
import com.example.dailynews.payloads.req.UpdateArticleRequest;
import com.example.dailynews.services.article.ArticleService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/articles")
public class ArticleController {
  @Autowired
  ArticleService articleService;

  @PostMapping
  public ResponseEntity<?> createArticle(@RequestBody @Valid AddArticleRequest request){
    return articleService.addArticleService(request);
  }

  @PostMapping("/update")
  public ResponseEntity<?> updateArticle(@RequestBody @Valid UpdateArticleRequest request){
    return articleService.updateArticlesService(request);
  }

  @GetMapping
  public ResponseEntity<?> getArticles(){
    return articleService.getArticlesService();
  }

  @GetMapping("/trending")
  public ResponseEntity<?> getTrendingArticles(){
    return articleService.getTrendingArticlesService();
  }

  @GetMapping("/latest")
  public ResponseEntity<?> getLatestArticles(){
    return articleService.getLatestArticlesService();
  }

  @GetMapping("/recommended")
  public ResponseEntity<?> getRecommendedArticles(){
    return articleService.getRecommendedArticlesService();
  }
  
  @GetMapping("/popular")
  public ResponseEntity<?> getPopularArticles(){
    return articleService.getPopularArticlesService();
  }

  @PutMapping("/valid")
  public ResponseEntity<?> validateArticles(@RequestParam String id){
    return articleService.validityArticlesService(id);
  }
}

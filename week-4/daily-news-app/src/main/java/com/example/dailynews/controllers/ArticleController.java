package com.example.dailynews.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dailynews.payloads.req.AddArticleRequest;
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

  @GetMapping
  public ResponseEntity<?> getArticles(){
    return articleService.getArticlesService();
  }
}

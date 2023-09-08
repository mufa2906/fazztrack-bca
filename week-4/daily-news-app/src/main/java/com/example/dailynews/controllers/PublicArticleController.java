package com.example.dailynews.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dailynews.payloads.req.article.AddArticleCommentRequest;
import com.example.dailynews.services.article.ArticleService;
import com.example.dailynews.services.articleComment.ArticleCommentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/articles")

public class PublicArticleController {
  @Autowired
  ArticleService articleService;

  @Autowired
  ArticleCommentService articleCommentService;

  @GetMapping
  public ResponseEntity<?> getArticles() {
    return articleService.getArticlesService();
  }

  @GetMapping("/trending")
  public ResponseEntity<?> getTrendingArticles() {
    return articleService.getTrendingArticlesService();
  }

  @GetMapping("/latest")
  public ResponseEntity<?> getLatestArticles() {
    return articleService.getLatestArticlesService();
  }

  @GetMapping("/recommended")
  public ResponseEntity<?> getRecommendedArticles() {
    return articleService.getRecommendedArticlesService();
  }

  @GetMapping("/popular")
  public ResponseEntity<?> getPopularArticles() {
    return articleService.getPopularArticlesService();
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> getArticlesById(@PathVariable String id) {
    return articleService.getArticlesByIdService(id);
  }

  @GetMapping("/{articleId}/comment")
  public ResponseEntity<?> getArticleCommentsByArticle(@PathVariable String articleId) {
    return articleCommentService.getArticleCommentsByArticleService(articleId);
  }

  @PostMapping("/{articleId}/comment/create")
  public ResponseEntity<?> createArticleComment(@RequestBody @Valid AddArticleCommentRequest request, @PathVariable String articleId) {
    return articleCommentService.addArticleCommentService(request, articleId);
  }

}

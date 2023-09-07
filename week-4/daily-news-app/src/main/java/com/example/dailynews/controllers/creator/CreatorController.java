package com.example.dailynews.controllers.creator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dailynews.payloads.req.AddArticleRequest;
import com.example.dailynews.payloads.req.UpdateArticleRequest;
import com.example.dailynews.services.article.ArticleService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/articles")
@PreAuthorize("hasRole('ADMIN') or hasRole('CREATOR')")
public class CreatorController {
  @Autowired
  ArticleService articleService;

  @PostMapping("/create")
  public ResponseEntity<?> createArticle(@RequestBody @Valid AddArticleRequest request) {
    return articleService.addArticleService(request);
  }

  @PostMapping("/{id}/update")
  public ResponseEntity<?> updateArticle(@RequestBody @Valid UpdateArticleRequest request, @PathVariable String id) {
    return articleService.updateArticlesService(request, id);
  }


}

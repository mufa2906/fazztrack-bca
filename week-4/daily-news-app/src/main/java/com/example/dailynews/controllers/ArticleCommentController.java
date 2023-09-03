package com.example.dailynews.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dailynews.payloads.req.AddArticleCommentRequest;
import com.example.dailynews.services.articleComment.ArticleCommentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("article-comments")
public class ArticleCommentController {
  @Autowired
  ArticleCommentService articleCommentService;

  @PostMapping
  public ResponseEntity<?> createArticleComment(@RequestBody @Valid AddArticleCommentRequest request){
    return articleCommentService.addArticleCommentService(request);
  }

  @GetMapping
  public ResponseEntity<?> getArticleComments(){
    return articleCommentService.getArticleCommentsService();
  }
}

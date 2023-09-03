package com.example.dailynews.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dailynews.payloads.req.AddArticleTypeRequest;
import com.example.dailynews.services.articleType.ArticleTypeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/article-types")
public class ArticleTypeController {
  @Autowired
  ArticleTypeService articleTypeService;

  @PostMapping
  public ResponseEntity<?> createArticleType(@RequestBody @Valid AddArticleTypeRequest  request){
    return articleTypeService.addArticleTypeService(request);
  }
  
  @GetMapping
  public ResponseEntity<?> getArticleTypes(){
    return articleTypeService.getArticleTypesService();
  }
}

package com.example.dailynews.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.dailynews.services.storageArticle.StorageArticleService;

@RestController
@RequestMapping("/files/article")
public class FileController {
  @Autowired
  StorageArticleService storageArticleService;

  @PostMapping
  @PreAuthorize("hasRole('ADMIN') or hasRole('CREATOR')")
  public ResponseEntity<?> storeImage(@RequestParam(value = "file") MultipartFile file,
      @RequestParam(value = "articleId") String articleId) throws IOException {
    return storageArticleService.storeImage(file, articleId);
  }

  @GetMapping("/{imageId}")
  public ResponseEntity<?> getImage(@PathVariable String imageId) {
    return storageArticleService.loadImage(imageId);
  }
}

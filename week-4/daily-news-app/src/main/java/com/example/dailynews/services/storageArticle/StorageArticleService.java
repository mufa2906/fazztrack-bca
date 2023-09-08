package com.example.dailynews.services.storageArticle;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface StorageArticleService {
  ResponseEntity<?> storeImage(MultipartFile file, String articleId) throws IOException;

  ResponseEntity<?> loadImage(String imageId);

  ResponseEntity<?> deleteImage(String imageId);

  ResponseEntity<?> getImages();
}

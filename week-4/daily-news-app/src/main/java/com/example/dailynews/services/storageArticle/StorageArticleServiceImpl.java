package com.example.dailynews.services.storageArticle;

import java.io.IOException;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.dailynews.models.Article;
import com.example.dailynews.models.ImageArticle;
import com.example.dailynews.payloads.res.ResponseHandler;
import com.example.dailynews.repositories.ArticleRepository;
import com.example.dailynews.repositories.ImageArticleRepository;

@Service
public class StorageArticleServiceImpl implements StorageArticleService {
  @Autowired
  ImageArticleRepository imageArticleRepository;

  @Autowired
  ArticleRepository articleRepository;

  @Override
  public ResponseEntity<?> storeImage(MultipartFile file, String articleId) throws IOException {

    String imgName = StringUtils.cleanPath(file.getOriginalFilename());

    Article article = articleRepository.findById(articleId)
        .orElseThrow(() -> new NoSuchElementException("Article is not found"));

    ImageArticle imageArticle = new ImageArticle(imgName, file.getBytes(), article);
    imageArticleRepository.save(imageArticle);

    String sharedUrl = ServletUriComponentsBuilder
        .fromCurrentContextPath()
        .path("/files/article/")
        .path(imageArticle.getId())
        .toUriString();

    imageArticle.setSharedUrl(sharedUrl);
    imageArticleRepository.save(imageArticle);

    return ResponseHandler.responseData(201, "Success store image", imageArticle);
  }

  @Override
  public ResponseEntity<?> loadImage(String imageId) {
    ImageArticle imageArticle = imageArticleRepository.findById(imageId)
        .orElseThrow(() -> new NoSuchElementException("Image is not found!"));

    // ini resp keluaran json
    // return ResponseHandler.responseData(200, "Success load image", imageArticle);

    // ini resp keluaran image bisa di fetch
    return ResponseEntity.ok()
        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=\"" + imageArticle.getImageName() + "\"")
        .body(imageArticle.getData());
  }

}

package com.example.dailynews.services.storageArticle;

import java.io.IOException;
import java.util.List;
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
import com.example.dailynews.validators.ArticleValidation;

@Service
public class StorageArticleServiceImpl implements StorageArticleService {
  @Autowired
  ImageArticleRepository imageArticleRepository;

  @Autowired
  ArticleRepository articleRepository;

  @Autowired
  ArticleValidation articleValidation;

  @Override
  public ResponseEntity<?> storeImage(MultipartFile file, String articleId) throws IOException {

    String imgName = StringUtils.cleanPath(file.getOriginalFilename());

    Article article = articleRepository.findById(articleId).orElse(null);
    articleValidation.validateArticle(article);

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

    if(imageArticle.getIsDeleted()){
      throw new NoSuchElementException("Image already deleted!");
    }

    // ini resp keluaran json
    // return ResponseHandler.responseData(200, "Success load image", imageArticle);

    // ini resp keluaran image bisa di fetch
    return ResponseEntity.ok()
        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=\"" + imageArticle.getImageName() + "\"")
        .body(imageArticle.getData());
  }

  @Override
  public ResponseEntity<?> deleteImage(String imageId) {
    ImageArticle imageArticle = imageArticleRepository.findById(imageId)
        .orElseThrow(() -> new NoSuchElementException("Image is not found!"));
    imageArticle.setIsDeleted(true);
    imageArticleRepository.save(imageArticle);

    return ResponseHandler.responseMessage(200, "Successfully remove image");
  }

  @Override
  public ResponseEntity<?> getImages() {
    List<ImageArticle> images = imageArticleRepository.findAll();
    return ResponseHandler.responseData(200, "Successfully show all image", images);
  }

  

}

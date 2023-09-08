package com.example.dailynews.services.articleType;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.dailynews.models.TypeArticle;
import com.example.dailynews.payloads.req.article.AddArticleTypeRequest;
import com.example.dailynews.payloads.res.ResponseHandler;
import com.example.dailynews.repositories.TypeArticleRepository;

@Service
public class ArticleTypeServiceImpl implements ArticleTypeService{
  @Autowired
  TypeArticleRepository typeArticleRepository;

  @Override
  public ResponseEntity<?> addArticleTypeService(AddArticleTypeRequest request) {
    TypeArticle typeArticle = typeArticleRepository.findByTypeIgnoreCase(request.getType());
    if (!Objects.isNull(typeArticle)) {
      if(!typeArticle.getIsDeleted()){
        throw new IllegalArgumentException("Article type already exists!");
      } else {
        typeArticle.setIsDeleted(false);
      }
    } else {
      typeArticle = new TypeArticle(request.getType());
    }
    typeArticleRepository.save(typeArticle);
    return ResponseHandler.responseData(201, "Article type successfully added!", typeArticle);
  }

  @Override
  public ResponseEntity<?> getArticleTypesService() {
    List<TypeArticle> typeArticles = typeArticleRepository.findAll();
    return ResponseHandler.responseData(200, "Show all article types!", typeArticles);
  }

  @Override
  public ResponseEntity<?> deleteArticleTypeService(String type) {
    TypeArticle typeArticle = typeArticleRepository.findByTypeIgnoreCase(type);
    if (Objects.isNull(typeArticle)) {
      throw new IllegalArgumentException("Article type is not found!");
    }
    
    typeArticle.setIsDeleted(true);
    typeArticleRepository.save(typeArticle);

    return ResponseHandler.responseMessage(200, "Article type successfully deleted!");
  }

  
  
}

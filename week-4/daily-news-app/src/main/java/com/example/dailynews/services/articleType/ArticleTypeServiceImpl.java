package com.example.dailynews.services.articleType;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.dailynews.models.ArticleType;
import com.example.dailynews.payloads.req.AddArticleTypeRequest;
import com.example.dailynews.payloads.res.ResponseHandler;
import com.example.dailynews.repositories.ArticleTypeRepository;

@Service
public class ArticleTypeServiceImpl implements ArticleTypeService{
  @Autowired
  ArticleTypeRepository articleTypeRepository;

  @Override
  public ResponseEntity<?> addArticleTypeService(AddArticleTypeRequest request) {
    ArticleType articleType = new ArticleType(request.getArticleType());
    articleTypeRepository.save(articleType);
    return ResponseHandler.responseData(201, "Article type successfully added!", articleType);
  }

  @Override
  public ResponseEntity<?> getArticleTypesService() {
    List<ArticleType> articleTypes = articleTypeRepository.findAll();
    return ResponseHandler.responseData(200, "Show all article types!", articleTypes);
  }
  
}

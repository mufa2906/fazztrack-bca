package com.example.dailynews.services.articleType;

import java.util.List;

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
  TypeArticleRepository articleTypeRepository;

  @Override
  public ResponseEntity<?> addArticleTypeService(AddArticleTypeRequest request) {
    if(articleTypeRepository.existsByTypeIgnoreCase(request.getType())){
      throw new IllegalArgumentException("Article type already exists!");
    }
    TypeArticle articleType = new TypeArticle(request.getType());
    articleTypeRepository.save(articleType);
    return ResponseHandler.responseData(201, "Article type successfully added!", articleType);
  }

  @Override
  public ResponseEntity<?> getArticleTypesService() {
    List<TypeArticle> articleTypes = articleTypeRepository.findAll();
    return ResponseHandler.responseData(200, "Show all article types!", articleTypes);
  }
  
}

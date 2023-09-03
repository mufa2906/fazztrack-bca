package com.example.dailynews.services.articleComment;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.dailynews.models.Article;
import com.example.dailynews.models.ArticleComment;
import com.example.dailynews.payloads.req.AddArticleCommentRequest;
import com.example.dailynews.payloads.res.ResponseHandler;
import com.example.dailynews.repositories.ArticleCommentRepository;
import com.example.dailynews.repositories.ArticleRepository;

@Service
public class ArticleCommentServiceImpl implements ArticleCommentService {
  @Autowired
  ArticleCommentRepository articleCommentRespository;

  @Autowired
  ArticleRepository articleRepository;


  @Override
  public ResponseEntity<?> addArticleCommentService(AddArticleCommentRequest request) {
    Article article = articleRepository.findById(request.getArticleId()).orElseThrow(()->{
      throw new NoSuchElementException("Article is not found!");
    });

    ArticleComment comment = new ArticleComment(request.getCommentText(), article, request.getComentator());
    articleCommentRespository.save(comment); 
    
    return ResponseHandler.responseData(201, "comment successfully added to article with title "+article.getTitle()+"!", comment);
  }

  @Override
  public ResponseEntity<?> getArticleCommentsService() {
    List<ArticleComment> comments = articleCommentRespository.findAll();
    return ResponseHandler.responseData(200, "show all comments!", comments);
  }
  
  @Override
  public ResponseEntity<?> getArticleCommentsByArticleService(String articleId) {
    Article article = articleRepository.findById(articleId).orElseThrow(() -> {
    throw new NoSuchElementException("Article is not found!");
  });
  List<ArticleComment> comments = articleCommentRespository.findByArticle(article);
  
  return ResponseHandler.responseData(200, "show all comments!", comments);
  }
   
}

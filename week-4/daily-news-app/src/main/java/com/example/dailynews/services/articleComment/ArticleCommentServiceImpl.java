package com.example.dailynews.services.articleComment;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.dailynews.models.Article;
import com.example.dailynews.models.CommentArticle;
import com.example.dailynews.payloads.req.article.AddArticleCommentRequest;
import com.example.dailynews.payloads.res.ResponseHandler;
import com.example.dailynews.repositories.CommentArticleRepository;
import com.example.dailynews.repositories.ArticleRepository;

@Service
public class ArticleCommentServiceImpl implements ArticleCommentService {
  @Autowired
  CommentArticleRepository articleCommentRespository;

  @Autowired
  ArticleRepository articleRepository;


  @Override
  public ResponseEntity<?> addArticleCommentService(AddArticleCommentRequest request, String articleId) {
    Article article = articleRepository.findById(articleId).orElseThrow(()->{
      throw new NoSuchElementException("Article is not found!");
    });

    CommentArticle comment = new CommentArticle(request.getCommentText(), article, request.getComentator());
    articleCommentRespository.save(comment); 
    
    return ResponseHandler.responseData(201, "comment successfully added to article with title "+article.getTitle()+"!", comment);
  }

  @Override
  public ResponseEntity<?> getArticleCommentsService() {
    List<CommentArticle> comments = articleCommentRespository.findAll();
    return ResponseHandler.responseData(200, "show all comments!", comments);
  }
  
  @Override
  public ResponseEntity<?> getArticleCommentsByArticleService(String articleId) {
    Article article = articleRepository.findById(articleId).orElseThrow(() -> {
    throw new NoSuchElementException("Article is not found!");
  });
  List<CommentArticle> comments = articleCommentRespository.findByArticle(article);
  
  return ResponseHandler.responseData(200, "show all comments!", comments);
  }
   
}

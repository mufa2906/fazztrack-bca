package com.example.dailynews.services.article;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.dailynews.models.Article;
import com.example.dailynews.models.ArticleType;
import com.example.dailynews.models.User;
import com.example.dailynews.payloads.req.AddArticleRequest;
import com.example.dailynews.payloads.req.UpdateArticleRequest;
import com.example.dailynews.payloads.res.ResponseHandler;
import com.example.dailynews.repositories.ArticleRepository;
import com.example.dailynews.repositories.ArticleTypeRepository;
import com.example.dailynews.repositories.UserRepository;

@Service
public class ArticleServiceImpl implements ArticleService {
  @Autowired
  ArticleRepository articleRepository;

  @Autowired
  UserRepository userRepository;

  @Autowired
  ArticleTypeRepository articleTypeRepository;

  @Override
  public ResponseEntity<?> addArticleService(AddArticleRequest request) {
    // validasi author ada ato tidak
    User author = userRepository.findByUsername(request.getAuthor()).orElseThrow(() -> {
      throw new NoSuchElementException("Username is not found!");
    });

    ArticleType articleType = articleTypeRepository.findById(request.getArticleType()).orElseThrow(() -> {
      throw new NoSuchElementException("Article type is not found!");
    });

    Article article = new Article(request.getTitle(), request.getDescription(), author, articleType);
    articleRepository.save(article);

    return ResponseHandler.responseData(201, "Article successfully added!", article);
  }

  @Override
  public ResponseEntity<?> getArticlesService() {
    List<Article> articles = articleRepository.findAll();
    return ResponseHandler.responseData(200, "Show all articles!", articles);
  }

  @Override
  public ResponseEntity<?> updateArticlesService(UpdateArticleRequest request) {
    Article article = articleRepository.findById(request.getArticleId()).orElseThrow(() -> {
      throw new NoSuchElementException("Article is not found!");
    });

    if (!request.getTitle().isEmpty()) {
      article.setTitle(request.getTitle());
    }
    if (!request.getDescription().isEmpty()) {
      article.setTitle(request.getDescription());
    }

    if (request.getArticleType() != null) {
      ArticleType type = articleTypeRepository.findById(request.getArticleType()).orElseThrow(() -> {
        throw new NoSuchElementException("Article type is not found!");
      });
      article.setArticleType(type);
    }

    if(!request.getUpdater().equalsIgnoreCase("creator") && !request.getUpdater().equalsIgnoreCase("admin")){
      throw new IllegalArgumentException("Article update only for creator or admin!");
    }

    articleRepository.save(article);
    return ResponseHandler.responseData(200, "Article successfully updated!", article);
  }

  @Override
  public ResponseEntity<?> getTrendingArticlesService() {
    List<Article> articles = articleRepository.OrderByViewsCountDesc();
    return ResponseHandler.responseData(200, "Show trending articles!", articles);
  }

  @Override
  public ResponseEntity<?> getLatestArticlesService() {
    List<Article> articles = articleRepository.OrderByCreatedAtDesc();
    return ResponseHandler.responseData(200, "Show latest articles!", articles);
  }

  @Override
  public ResponseEntity<?> getRecommendedArticlesService() {
    // TODO rekom
    return null;
  }

  @Override
  public ResponseEntity<?> getPopularArticlesService() {
    // TODO populer
    return null;
  }

  @Override
  public ResponseEntity<?> validityArticlesService(String id) {
    Article article = articleRepository.findById(id).orElseThrow(() -> {
      throw new NoSuchElementException("Article is not found!");
    });
    article.setIsValid(true);
    return ResponseHandler.responseMessage(200, "Article with title "+article.getTitle()+" is valid!");
  }

}

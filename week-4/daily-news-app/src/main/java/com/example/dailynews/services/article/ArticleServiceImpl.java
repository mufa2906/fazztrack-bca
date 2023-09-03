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
    //validasi author ada ato tidak
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

}

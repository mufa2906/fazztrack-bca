package com.example.dailynews.services.article;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.dailynews.models.Article;
import com.example.dailynews.models.TypeArticle;
import com.example.dailynews.models.Role;
import com.example.dailynews.models.User;
import com.example.dailynews.payloads.req.article.AddArticleRequest;
import com.example.dailynews.payloads.req.article.UpdateArticleRequest;
import com.example.dailynews.payloads.req.article.ValidateArticleRequest;
import com.example.dailynews.payloads.res.ResponseHandler;
import com.example.dailynews.repositories.ArticleRepository;
import com.example.dailynews.repositories.TypeArticleRepository;
import com.example.dailynews.repositories.RoleRepository;
import com.example.dailynews.repositories.UserRepository;
import com.example.dailynews.validators.ArticleValidation;

@Service
public class ArticleServiceImpl implements ArticleService {
  @Autowired
  ArticleRepository articleRepository;

  @Autowired
  UserRepository userRepository;

  @Autowired
  TypeArticleRepository articleTypeRepository;

  @Autowired
  RoleRepository roleRepository;

  @Autowired
  ArticleValidation articleValidation;

  @Override
  public ResponseEntity<?> addArticleService(AddArticleRequest request) {
    // validasi author ada ato tidak
    User author = userRepository.findByUsername(request.getAuthor());
    if (Objects.isNull(author)) {
      throw new NoSuchElementException("Author is not found!");
    }

    Set<Role> userRoles = author.getRoles();

    // harusnya untuk entitas yang akses endpoint sudah dicek, tapi mungkin
    // memberikan akses ke admin untuk publish artikel atas nama author lain yg
    // creator/admin juga rolenya
    if (!userRoles.contains(roleRepository.findByName("ROLE_ADMIN"))
        && !userRoles.contains(roleRepository.findByName("ROLE_CREATOR"))) {
      throw new NoSuchElementException("You dont have authority to create article!");
    }

    TypeArticle articleType = articleTypeRepository.findById(request.getArticleType()).orElseThrow(() -> {
      throw new NoSuchElementException("Article type is not found!");
    });

    Article article = new Article(request.getTitle(), request.getDescription(), author, articleType);
    articleRepository.save(article);

    return ResponseHandler.responseData(201, "Article successfully added!", article);
  }

  @Override
  public ResponseEntity<?> getArticlesService(Boolean isDeleted) {
    List<Article> articles;
    if (isDeleted == null) {
      articles = articleRepository.findAll();
    } else {
      articles = articleRepository.findByIsDeleted(isDeleted);
    }
    return ResponseHandler.responseData(200, "Show all articles!", articles);

  }

  @Override
  public ResponseEntity<?> getArticlesByIdService(String id) {
    Article article = articleRepository.findById(id).orElse(null);
    articleValidation.validateArticle(article);
    article.setViewsCount(article.getViewsCount() + 1);
    articleRepository.save(article);
    return ResponseHandler.responseData(200, "Article successfully showed!", article);
  }

  @Override
  public ResponseEntity<?> updateArticlesService(UpdateArticleRequest request, String id) {
    Article article = articleRepository.findById(id).orElse(null);
    articleValidation.validateArticle(article);

    User updater = userRepository.findById(request.getUpdaterId()).orElseThrow(() -> {
      throw new NoSuchElementException("User is not found!");
    });
    article.setUpdateBy(updater);

    Set<Role> updaterRoles = updater.getRoles();

    if (!updaterRoles.contains(roleRepository.findByName("ROLE_ADMIN"))
        && !updater.getId().equals(article.getAuthor().getId())) {
      throw new NoSuchElementException("You dont have authority to update this article!");
    }

    if (!request.getTitle().isEmpty()) {
      article.setTitle(request.getTitle());
    }
    if (!request.getDescription().isEmpty()) {
      article.setDescription(request.getDescription());
    }

    if (request.getArticleType() != null) {
      TypeArticle type = articleTypeRepository.findById(request.getArticleType()).orElseThrow(() -> {
        throw new NoSuchElementException("Article type is not found!");
      });
      article.setArticleType(type);
    }

    articleRepository.save(article);
    return ResponseHandler.responseData(200, "Article successfully updated!", article);
  }

  @Override
  public ResponseEntity<?> getTrendingArticlesService() {
    List<Article> articles = articleRepository.findFirst3ByOrderByViewsCountDesc();
    return ResponseHandler.responseData(200, "Show trending articles!", articles);
  }

  @Override
  public ResponseEntity<?> getLatestArticlesService() {
    List<Article> articles = articleRepository.OrderByCreatedAtDesc();
    return ResponseHandler.responseData(200, "Show latest articles!", articles);
  }

  @Override
  public ResponseEntity<?> getRecommendedArticlesService() {
    List<Article> articles = articleRepository.findByIsValidIsTrue();
    return ResponseHandler.responseData(200, "Show recommended articles!", articles);
  }

  @Override
  public ResponseEntity<?> getPopularArticlesService() {
    List<Article> articles = articleRepository.findTop3ByOrderByLikesCountDesc();
    return ResponseHandler.responseData(200, "Show popular articles!", articles);
  }

  @Override
  public ResponseEntity<?> validityArticlesService(ValidateArticleRequest request, String articleId) {
    User validator = userRepository.findById(request.getValidatorId()).orElseThrow(() -> {
      throw new NoSuchElementException("User is not found!");
    });

    Set<Role> validatorRoles = validator.getRoles();

    if (!validatorRoles.contains(roleRepository.findByName("ROLE_ADMIN"))) {
      throw new NoSuchElementException("You dont have authority to validate this article!");
    }

    Article article = articleRepository.findById(articleId).orElse(null);
    articleValidation.validateArticle(article);

    if (!article.getIsValid()) {
      article.setIsValid(true);
      articleRepository.save(article);
      return ResponseHandler.responseMessage(200, "Article with title '" + article.getTitle() + "' is valid!");
    }
    return ResponseHandler.responseMessage(200, "Article with title '" + article.getTitle() + "' already valid!");
  }

  @Override
  public ResponseEntity<?> deleteArticlesByIdService(String id) {
    Article article = articleRepository.findById(id).orElse(null);
    articleValidation.validateArticle(article);

    article.setIsDeleted(true);
    articleRepository.save(article);

    return ResponseHandler.responseMessage(200, "Succesfully deleted article");
  }

}

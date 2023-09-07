package com.example.dailynews.controllers.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dailynews.payloads.req.AddArticleTypeRequest;
import com.example.dailynews.payloads.req.AddRoleRequest;
import com.example.dailynews.payloads.req.ValidateArticleRequest;
import com.example.dailynews.services.article.ArticleService;
import com.example.dailynews.services.articleComment.ArticleCommentService;
import com.example.dailynews.services.articleType.ArticleTypeService;
import com.example.dailynews.services.articleWishlist.ArticleWishlistService;
import com.example.dailynews.services.role.RoleService;
import com.example.dailynews.services.storageArticle.StorageArticleService;
import com.example.dailynews.services.user.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/admin")
public class AdminController {

  @Autowired
  ArticleService articleService;

  @Autowired
  ArticleTypeService articleTypeService;

  @Autowired
  UserService userService;

  @Autowired
  RoleService roleService;

  @Autowired
  ArticleWishlistService wishlistService;

  @Autowired
  ArticleCommentService commentService;

  @Autowired
  StorageArticleService storageArticleService;

  @GetMapping("/users/{id}")
  public ResponseEntity<?> getUserById(@PathVariable String id) {
    return userService.getUserByIdService(id);
  }

  @GetMapping("/article-types")
  public ResponseEntity<?> getArticleTypes() {
    return articleTypeService.getArticleTypesService();
  }

  @PostMapping("/article-types/create")
  public ResponseEntity<?> createArticleType(@RequestBody @Valid AddArticleTypeRequest request) {
    return articleTypeService.addArticleTypeService(request);
  }

  @PutMapping("/articles/{articleId}/valid")
  public ResponseEntity<?> validateArticles(@RequestBody @Valid ValidateArticleRequest request,
      @PathVariable String articleId) {
    return articleService.validityArticlesService(request, articleId);
  }

  @GetMapping("/roles")
  public ResponseEntity<?> getRoles() {
    return roleService.getRolesService();
  }

  @PostMapping("/roles/create")
  public ResponseEntity<?> createRole(@RequestBody @Valid AddRoleRequest request) {
    return roleService.addRoleService(request);
  }

  @GetMapping("/article-comments")
  public ResponseEntity<?> getCommentWishlist() {
    return commentService.getArticleCommentsService();
  }

  @GetMapping("/article-wishlist")
  public ResponseEntity<?> getArticleWishlist() {
    return wishlistService.getArticleWishlistService();
  }

}

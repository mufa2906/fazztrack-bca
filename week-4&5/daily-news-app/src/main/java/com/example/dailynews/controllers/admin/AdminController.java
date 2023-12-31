package com.example.dailynews.controllers.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.dailynews.payloads.req.article.AddArticleTypeRequest;
import com.example.dailynews.payloads.req.article.ValidateArticleRequest;
import com.example.dailynews.payloads.req.role.AddRoleRequest;
import com.example.dailynews.services.article.ArticleService;
import com.example.dailynews.services.articleComment.ArticleCommentService;
import com.example.dailynews.services.articleType.ArticleTypeService;
import com.example.dailynews.services.articleWishlist.ArticleWishlistService;
import com.example.dailynews.services.role.RoleService;
import com.example.dailynews.services.storageArticle.StorageArticleService;
import com.example.dailynews.services.user.UserService;

import jakarta.annotation.security.RolesAllowed;
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


  @PostMapping("/users/{username}/delete")
  @RolesAllowed("hasRole('ROLE_ADMIN')" )
  public ResponseEntity<?> deleteUserByUsername(@PathVariable String username) {
    return userService.deleteUserByUsernameService(username);
  }

  @GetMapping("/users/{username}")
  public ResponseEntity<?> getUserById(@PathVariable String username) {
    return userService.getUserByUsernameService(username);
  }

  @GetMapping("/article-types")
  public ResponseEntity<?> getArticleTypes() {
    return articleTypeService.getArticleTypesService();
  }

  @PostMapping("/article-types/create")
  public ResponseEntity<?> createArticleType(@RequestBody @Valid AddArticleTypeRequest request) {
    return articleTypeService.addArticleTypeService(request);
  }

  @PostMapping("/article-types/delete")
  public ResponseEntity<?> deleteArticleType(@RequestParam(value="type", required=true) String type) {
    return articleTypeService.deleteArticleTypeService(type);
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

  @PostMapping("/roles/delete")
  public ResponseEntity<?> createRole(@RequestParam(value="name", required = true) String name) {
    return roleService.deleteRoleService(name);
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

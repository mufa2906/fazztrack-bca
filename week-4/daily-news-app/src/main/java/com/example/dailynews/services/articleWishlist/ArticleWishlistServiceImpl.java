package com.example.dailynews.services.articleWishlist;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.dailynews.models.Article;
import com.example.dailynews.models.ArticleWishlist;
import com.example.dailynews.models.User;
import com.example.dailynews.payloads.req.AddArticleWishlistRequest;
import com.example.dailynews.payloads.res.ResponseHandler;
import com.example.dailynews.repositories.ArticleRepository;
import com.example.dailynews.repositories.ArticleWishlistRepository;
import com.example.dailynews.repositories.UserRepository;

@Service
public class ArticleWishlistServiceImpl implements ArticleWishlistService {
  @Autowired
  ArticleWishlistRepository wishlistRepository;

  @Autowired
  ArticleRepository articleRepository;

  @Autowired
  UserRepository userRepository;

  @Override
  public ResponseEntity<?> addArticleWishlist(AddArticleWishlistRequest request) {
    Article article = articleRepository.findById(request.getArticleId()).orElseThrow(() -> {
      throw new NoSuchElementException("Article is not found!");
    });

    User user = userRepository.findByUsername(request.getUserUsername()).orElseThrow(() -> {
      throw new NoSuchElementException("User is not found!");
    });

    ArticleWishlist wishlist = new ArticleWishlist(user, article);
    wishlistRepository.save(wishlist);

    return ResponseHandler.responseData(201,
        user.getUsername() + " successfully added article to wishlist!", wishlist);
  }

  @Override
  public ResponseEntity<?> getArticleWishlistService() {
    List<ArticleWishlist> wishlist = wishlistRepository.findAll();
    return ResponseHandler.responseData(200,
        "show all wishlist!", wishlist);
  }

  @Override
  public ResponseEntity<?> getArticleWishlistByUserService(String userId) {
    User user = userRepository.findById(userId).orElseThrow(() -> {
      throw new NoSuchElementException("User is not found!");
    });

    List<ArticleWishlist> wishlist = wishlistRepository.findByUser(user);
    return ResponseHandler.responseData(200,
        "show all "+ user.getUsername()+"'s wishlist!", wishlist);
  }

}

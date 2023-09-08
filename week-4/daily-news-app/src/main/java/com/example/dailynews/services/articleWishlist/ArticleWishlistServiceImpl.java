package com.example.dailynews.services.articleWishlist;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.dailynews.models.Article;
import com.example.dailynews.models.WishlistArticle;
import com.example.dailynews.models.User;
import com.example.dailynews.payloads.req.AddArticleWishlistRequest;
import com.example.dailynews.payloads.res.ResponseHandler;
import com.example.dailynews.repositories.ArticleRepository;
import com.example.dailynews.repositories.WishlistArticleRepository;
import com.example.dailynews.repositories.UserRepository;

@Service
public class ArticleWishlistServiceImpl implements ArticleWishlistService {
  @Autowired
  WishlistArticleRepository wishlistRepository;

  @Autowired
  ArticleRepository articleRepository;

  @Autowired
  UserRepository userRepository;

  @Override
  public ResponseEntity<?> addArticleWishlist(AddArticleWishlistRequest request) {
    Article article = articleRepository.findById(request.getArticleId()).orElseThrow(() -> {
      throw new NoSuchElementException("Article is not found!");
    });

    User user = userRepository.findByUsername(request.getUsername());

    List<WishlistArticle> userWishlist = wishlistRepository.findByUser(user);
    // for (WishlistArticle wishlist: userWishlist) {
    //   if(wishlist.getArticle().equals(article)){
    //     throw new IllegalStateException("Article has been added to wishlist!");
    //   }
    // }
    
    if(userWishlist.stream().anyMatch(articleWishlist -> articleWishlist.getArticle().equals(article))){
      throw new IllegalStateException("Article has been added to wishlist!");
    }
    

    article.setLikesCount(article.getLikesCount() + 1);
    articleRepository.save(article);

    WishlistArticle wishlist = new WishlistArticle(user, article);
    wishlistRepository.save(wishlist);

    return ResponseHandler.responseData(201,
        user.getUsername() + " successfully added article to wishlist!", wishlist);
  }

  @Override
  public ResponseEntity<?> getArticleWishlistService() {
    List<WishlistArticle> wishlist = wishlistRepository.findAll();
    return ResponseHandler.responseData(200,
        "show all wishlist!", wishlist);
  }

  @Override
  public ResponseEntity<?> getArticleWishlistByUserService(String username) {
    User user = userRepository.findByUsername(username);
    if (Objects.isNull(user)){
      throw new NoSuchElementException("User is not found");
    }

    List<WishlistArticle> wishlist = wishlistRepository.findByUser(user);
    return ResponseHandler.responseData(200,
        "show all "+ user.getUsername()+"'s wishlist!", wishlist);
  }

}

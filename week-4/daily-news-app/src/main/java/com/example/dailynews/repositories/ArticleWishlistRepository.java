package com.example.dailynews.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.dailynews.models.ArticleWishlist;
import com.example.dailynews.models.User;

public interface ArticleWishlistRepository extends JpaRepository<ArticleWishlist, Long> {
  List<ArticleWishlist> findByUser(User user);
}

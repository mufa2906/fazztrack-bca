package com.example.dailynews.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.dailynews.models.WishlistArticle;
import com.example.dailynews.models.User;

public interface WishlistArticleRepository extends JpaRepository<WishlistArticle, Long> {
  List<WishlistArticle> findByUser(User user);
}

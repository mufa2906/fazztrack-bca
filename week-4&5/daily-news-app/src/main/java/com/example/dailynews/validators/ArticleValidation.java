package com.example.dailynews.validators;

import java.util.NoSuchElementException;
import java.util.Objects;

import org.springframework.stereotype.Component;

import com.example.dailynews.models.Article;

@Component
public class ArticleValidation {
  public void validateArticle(Article article) {
    if (article == null || Objects.isNull(article)) {
      throw new NoSuchElementException("Article has not yet registered");
    }

    if (article.getIsDeleted()) {
      throw new NoSuchElementException("Article already deleted");
    }
  }
}

package com.example.dailynews.payloads.req;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class UpdateArticleRequest {
  @NotEmpty(message = "Article id is required.")
  private String articleId;
  private String title;
  private String description;
  private Long articleType;
}

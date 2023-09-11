package com.example.dailynews.payloads.req.article;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AddArticleRequest {
  @NotEmpty(message = "Article title is required.")
  private String title;
  @NotEmpty(message = "Article description is required.")
  private String description;
  @NotEmpty(message = "Article author is required.")
  private String author;
  @NotNull(message = "Article type is required.")
  private Long articleType;
}

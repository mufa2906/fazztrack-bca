package com.example.dailynews.payloads.req;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class AddArticleWishlistRequest {
  @NotEmpty(message = "Article id is required.")
  private String articleId;
  @NotEmpty(message = "User username is required.")
  private String userUsername;
}

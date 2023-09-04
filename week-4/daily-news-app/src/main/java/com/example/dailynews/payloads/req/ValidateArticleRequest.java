package com.example.dailynews.payloads.req;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class ValidateArticleRequest {
  @NotEmpty(message = "Article id is required.")
  private String articleId;
  @NotEmpty(message = "Validator id is required.")
  private String validatorId;
}

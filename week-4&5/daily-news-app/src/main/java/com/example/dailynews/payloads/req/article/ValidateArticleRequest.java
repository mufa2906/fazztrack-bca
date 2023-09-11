package com.example.dailynews.payloads.req.article;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class ValidateArticleRequest {
  @NotEmpty(message = "Validator id is required.")
  private String validatorId;
}

package com.example.dailynews.payloads.req;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class UpdateArticleRequest {
  private String title;
  private String description;
  private Long articleType;
  @NotEmpty(message = "Updater is required.")
  private String updaterId;
}

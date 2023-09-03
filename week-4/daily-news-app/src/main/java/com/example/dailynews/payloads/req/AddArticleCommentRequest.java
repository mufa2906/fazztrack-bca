package com.example.dailynews.payloads.req;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class AddArticleCommentRequest {
  @NotEmpty(message = "Comment text is required.")
  private String commentText;
  @NotEmpty(message = "article id is required.")
  private String articleId;
  @NotEmpty(message = "Comentator name is required.")
  private String comentator;
}
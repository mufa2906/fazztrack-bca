package com.example.dailynews.payloads.req.article;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class AddArticleCommentRequest {
  @NotEmpty(message = "Comment text is required.")
  private String commentText;
  @NotEmpty(message = "Comentator name is required.")
  private String comentator;
}

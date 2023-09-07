package com.example.dailynews.payloads.req;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class AddArticleTypeRequest {
  @NotEmpty(message="Article type is required.")
  private String type;
}

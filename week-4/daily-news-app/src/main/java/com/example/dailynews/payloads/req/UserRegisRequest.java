package com.example.dailynews.payloads.req;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class UserRegisRequest {
  @NotEmpty(message="Username is required")
  private String username;
  @NotEmpty(message="Email is required")
  private String email;
  @NotEmpty(message="password is required")
  private String password;
  @NotEmpty(message="Role is required")
  private Long role;
}

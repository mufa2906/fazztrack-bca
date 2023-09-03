package com.example.dailynews.payloads.req;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserRegisRequest {
  @NotEmpty(message="Username is required.")
  private String username;
  @NotEmpty(message="Email is required.")
  private String email;
  @NotEmpty(message="password is required.")
  private String password;
  @NotNull(message="Role is required.")
  private Long role;
}

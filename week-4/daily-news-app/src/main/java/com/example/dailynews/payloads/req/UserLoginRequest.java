package com.example.dailynews.payloads.req;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class UserLoginRequest {
  @NotEmpty(message = "Username/Email is required")
  private String usernameOrEmail;
  @NotEmpty(message = "password is required")
  private String password;
}

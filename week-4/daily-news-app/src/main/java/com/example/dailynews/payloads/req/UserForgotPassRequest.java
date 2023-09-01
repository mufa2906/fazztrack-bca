package com.example.dailynews.payloads.req;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class UserForgotPassRequest {
  @NotEmpty(message = "Username is required")
  private String username;
  @NotEmpty(message = "Email is required")
  private String email;
  @NotEmpty(message = "New Password is required")
  private String newPassword;
}

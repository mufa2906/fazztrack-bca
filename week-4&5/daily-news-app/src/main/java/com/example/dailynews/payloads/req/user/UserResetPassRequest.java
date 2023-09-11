package com.example.dailynews.payloads.req.user;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class UserResetPassRequest {
  @NotEmpty(message = "Username is required.")
  private String username;
  @NotEmpty(message = "New Password is required.")
  private String newPassword;
}

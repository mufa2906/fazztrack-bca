package com.example.dailynews.payloads.req;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class UserResetPassRequest {
  @NotEmpty(message = "Username/email is required")
  private String usernameOrEmail;
  @NotEmpty(message = "New Password is required")
  private String newPassword;
}

package com.example.dailynews.payloads.req.user;

import lombok.Data;

@Data
public class UpdateUserRequest {
  private String email;
  private String password;
}

package com.example.dailynews.payloads.req.role;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class AddRoleRequest {
  @NotEmpty(message = "Role name is required.")
  private String roleName;
}

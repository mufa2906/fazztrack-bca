package com.example.dailynews.services.role;

import org.springframework.http.ResponseEntity;

import com.example.dailynews.payloads.req.AddRoleRequest;

public interface RoleService {
  ResponseEntity<?> addRoleService(AddRoleRequest request);

  ResponseEntity<?> getRolesService();

}

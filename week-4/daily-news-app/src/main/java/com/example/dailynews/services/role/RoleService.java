package com.example.dailynews.services.role;

import org.springframework.http.ResponseEntity;

import com.example.dailynews.payloads.req.role.AddRoleRequest;

public interface RoleService {
  ResponseEntity<?> addRoleService(AddRoleRequest request);

  ResponseEntity<?> getRolesService();

  ResponseEntity<?> deleteRoleService(String roleName);

}

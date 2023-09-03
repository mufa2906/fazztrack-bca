package com.example.dailynews.services.role;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.dailynews.models.Role;
import com.example.dailynews.payloads.req.AddRoleRequest;
import com.example.dailynews.payloads.res.ResponseHandler;
import com.example.dailynews.repositories.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService {
  @Autowired
  RoleRepository roleRepository;

  @Override
  public ResponseEntity<?> addRoleService(AddRoleRequest request) {
    Role role = new Role(request.getRoleName());
    roleRepository.save(role);
    return ResponseHandler.responseData(201, "Role successfully added!", role);
    
  }

  @Override
  public ResponseEntity<?> getRolesService() {
    List<Role> roles = roleRepository.findAll();
    return ResponseHandler.responseData(200, "Show all roles!", roles);
  }

}

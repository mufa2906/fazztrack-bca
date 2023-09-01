package com.example.dailynews.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.example.dailynews.payloads.req.AddRoleRequest;
import com.example.dailynews.services.role.RoleService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/roles")
public class RoleController {
  @Autowired
  RoleService roleService;

  @PostMapping
  public ResponseEntity<?> createRole(@RequestBody @Valid AddRoleRequest request){
    return roleService.addRoleService(request);
  }

  @GetMapping
  public ResponseEntity<?> getRoles(){
    return roleService.getRolesService();
  }
}

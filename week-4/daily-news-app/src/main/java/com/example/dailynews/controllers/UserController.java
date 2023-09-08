package com.example.dailynews.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.dailynews.payloads.req.user.UpdateUserRequest;
import com.example.dailynews.payloads.req.user.UserLoginRequest;
import com.example.dailynews.payloads.req.user.UserRegisRequest;
import com.example.dailynews.payloads.req.user.UserResetPassRequest;
import com.example.dailynews.services.user.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {
  @Autowired
  UserService userService;

  @PostMapping("/register")
  public ResponseEntity<?> createUser(@RequestBody @Valid UserRegisRequest request,
      @RequestParam(value = "role", defaultValue = "") String role) {
    return userService.regisUserService(request, role);
  }

  @PostMapping("/login")
  public ResponseEntity<?> loginUser(@RequestBody @Valid UserLoginRequest request) {
    return userService.loginUserService(request);
  }

  @PutMapping("/forgot-password")
  public ResponseEntity<?> resetPasswordUsers(@RequestBody @Valid UserResetPassRequest request) {
    return userService.resetPassUserService(request);
  }

  @GetMapping
  @PreAuthorize("hasRole('ROLE_ADMIN')")
  public ResponseEntity<?> getUsers(@RequestParam(value = "deleted", defaultValue = "") Boolean isDeleted) {
    return userService.getUsersService(isDeleted);
  }

  @PostMapping("/{username}/update")
  @PreAuthorize("#username == authentication.name or hasRole('ROLE_ADMIN')")
  public ResponseEntity<?> updateUserByUsername(UpdateUserRequest request, @PathVariable String username) {
    return userService.updateUserByUsernameService(request, username);
  }


}
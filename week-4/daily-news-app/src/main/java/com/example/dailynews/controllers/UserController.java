package com.example.dailynews.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.dailynews.payloads.req.UserLoginRequest;
import com.example.dailynews.payloads.req.UserRegisRequest;
import com.example.dailynews.payloads.req.UserResetPassRequest;
import com.example.dailynews.services.user.UserService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("users")
public class UserController {
  @Autowired
  UserService userService;

  @PostMapping("/register")
  public ResponseEntity<?> createUser(@RequestBody @Valid UserRegisRequest request) {
      return userService.regisUserService(request);
  }

  @GetMapping("/login")
  public ResponseEntity<?> loginUser(@RequestBody @Valid UserLoginRequest request) {
      return userService.loginUserService(request);
  }

  @GetMapping
  public ResponseEntity<?> getUsers(@RequestParam(value="deleted", defaultValue = "")  Boolean isDeleted) {
      return userService.getUsersService(isDeleted);
  }

  @PutMapping("/forgot-password")
  public ResponseEntity<?> resetPasswordUsers(@RequestBody @Valid UserResetPassRequest request){
    return userService.resetPassUserService(request);
  }
  
}
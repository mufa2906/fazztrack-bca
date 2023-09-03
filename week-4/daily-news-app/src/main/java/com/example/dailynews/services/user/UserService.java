package com.example.dailynews.services.user;

import org.springframework.http.ResponseEntity;

import com.example.dailynews.payloads.req.UserResetPassRequest;
import com.example.dailynews.payloads.req.UserLoginRequest;
import com.example.dailynews.payloads.req.UserRegisRequest;

public interface UserService {
  ResponseEntity<?> regisUserService(UserRegisRequest request);

  ResponseEntity<?> loginUserService(UserLoginRequest request);

  ResponseEntity<?> resetPassUserService(UserResetPassRequest request);

  ResponseEntity<?> getUsersService(Boolean isDeleted);

  ResponseEntity<?> getUserByIdService(String id);
}

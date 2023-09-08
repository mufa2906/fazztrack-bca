package com.example.dailynews.services.user;

import org.springframework.http.ResponseEntity;

import com.example.dailynews.payloads.req.user.UpdateUserRequest;
import com.example.dailynews.payloads.req.user.UserLoginRequest;
import com.example.dailynews.payloads.req.user.UserRegisRequest;
import com.example.dailynews.payloads.req.user.UserResetPassRequest;

public interface UserService {
  ResponseEntity<?> regisUserService(UserRegisRequest request, String role);

  ResponseEntity<?> loginUserService(UserLoginRequest request);

  ResponseEntity<?> resetPassUserService(UserResetPassRequest request);

  ResponseEntity<?> getUsersService(Boolean isDeleted);

  ResponseEntity<?> getUserByIdService(String id);

  ResponseEntity<?> updateUserByUsernameService(UpdateUserRequest request, String username);

  ResponseEntity<?> deleteUserByUsernameService(String username);
}

package com.example.dailynews.validators;

import java.util.NoSuchElementException;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.example.dailynews.models.User;
import com.example.dailynews.payloads.req.user.UpdateUserRequest;

@Component
public class UserValidation {
  @Autowired
  PasswordEncoder passwordEncoder;

  public void validateUser(User user) {
    if (user == null || Objects.isNull(user)) {
      throw new NoSuchElementException("User has not yet registered");
    }

    if (user.getIsDeleted().equals(true)) {
      throw new NoSuchElementException("User already deleted");
    }
  }

  public void validateUpdateUser(User user, UpdateUserRequest request) {
    if (!Objects.isNull(request.getEmail())) {
      user.setEmail(request.getEmail());
    }
    if (!Objects.isNull(request.getPassword())) {
      user.setPassword(passwordEncoder.encode(request.getPassword()));
    }
  }

}
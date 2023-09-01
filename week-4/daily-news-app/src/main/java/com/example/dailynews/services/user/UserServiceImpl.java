package com.example.dailynews.services.user;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.dailynews.models.Role;
import com.example.dailynews.models.User;
import com.example.dailynews.payloads.req.UserForgotPassRequest;
import com.example.dailynews.payloads.req.UserLoginRequest;
import com.example.dailynews.payloads.req.UserRegisRequest;
import com.example.dailynews.payloads.res.ResponseHandler;
import com.example.dailynews.repositories.RoleRepository;
import com.example.dailynews.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {
  @Autowired
  UserRepository userRepository;

  @Autowired
  RoleRepository roleRepository;

  @Override
  public ResponseEntity<?> regisUserService(UserRegisRequest request) {
    if (userRepository.existsByUsername(request.getUsername())) {
      throw new IllegalArgumentException("Username already registered");
    }

    if (userRepository.existsByEmail(request.getEmail())) {
      throw new IllegalArgumentException("Email already registered");
    }

    Role role = roleRepository.findById(request.getRole()).orElseThrow(() -> {
      throw new IllegalArgumentException("Role is not found");
    });

    User user = new User(request.getUsername(), request.getEmail(), request.getPassword(), role);

    userRepository.save(user);

    return ResponseHandler.responseData(201, "User successfully added!", user);
  }

  @Override
  public ResponseEntity<?> loginUserService(UserLoginRequest request) {
    if(!userRepository.existsByUsername(request.getUsernameOrEmail()) && !userRepository.existsByEmail(request.getUsernameOrEmail())){
      throw new NoSuchElementException("Username/Email belum melakukan registrasi");
    }

    User user = userRepository.getUsernameOrEmail(request.getUsernameOrEmail());

    if(user.getIsDeleted()) {
      throw new NoSuchElementException("Username sudah dihapus, tidak bisa digunakan kembali");
    }
 
    if(!user.getPassword().equals(request.getPassword())){
      throw new NoSuchElementException("Password Salah");
    }

    return ResponseHandler.responseMessage(200, "Login success");
  }

  @Override
  public ResponseEntity<?> forgotPassUserService(UserForgotPassRequest request) {
    if(!userRepository.existsByUsername(request.getUsername())){
      throw new IllegalArgumentException("Username is not found");
    }

    User user = userRepository.findByUsername(request.getUsername());

    if(user.getEmail().equals(request.getEmail())){
      throw new NoSuchElementException("Email does not match the registered username");
    }

    user.setPassword(request.getNewPassword());
    userRepository.save(user);

    return ResponseHandler.responseData(200, "Password successfully changed!",user);


  }

  @Override
  public ResponseEntity<?> getUsersService(Boolean isDeleted) {
    List<User> users;
    if (isDeleted == null) {
      users = userRepository.findAll();
    } else {
      users = userRepository.findByIsDeleted(isDeleted);
    }

    return ResponseHandler.responseData(200, "Users succesfully find All ", users);
  }

}

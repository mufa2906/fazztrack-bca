package com.example.dailynews.services.user;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.dailynews.configs.JwtUtil;
import com.example.dailynews.models.Role;
import com.example.dailynews.models.User;
import com.example.dailynews.payloads.req.user.UpdateUserRequest;
import com.example.dailynews.payloads.req.user.UserLoginRequest;
import com.example.dailynews.payloads.req.user.UserRegisRequest;
import com.example.dailynews.payloads.req.user.UserResetPassRequest;
import com.example.dailynews.payloads.res.ResponseHandler;
import com.example.dailynews.repositories.RoleRepository;
import com.example.dailynews.repositories.UserRepository;
import com.example.dailynews.validators.UserValidation;

@Service
public class UserServiceImpl implements UserService {
  @Autowired
  UserRepository userRepository;

  @Autowired
  RoleRepository roleRepository;

  @Autowired
  PasswordEncoder passwordEncoder;

  @Autowired
  JwtUtil jwtUtil;

  @Autowired
  AuthenticationManager authenticationManager;

  @Autowired
  UserValidation userValidation;

  @Override
  public ResponseEntity<?> regisUserService(UserRegisRequest request, String role) {
    if (userRepository.existsByUsername(request.getUsername())) {
      throw new IllegalArgumentException("Username already registered!");
    }

    if (userRepository.existsByEmail(request.getEmail())) {
      throw new IllegalArgumentException("Email already registered!");
    }

    String password = passwordEncoder.encode(request.getPassword());

    String strRole = (role.equals(null) || role.equals("") || !role.substring(0, 5).equals("ROLE_")) ? "ROLE_USER"
        : role;

    Role roleUser = roleRepository.findByName(strRole);
    if (Objects.isNull(roleUser)) {
      roleUser = new Role(strRole);
      roleRepository.save(roleUser);
    }

    Set<Role> roles = new HashSet<>();
    roles.add(roleUser);

    User user = new User(request.getUsername(), request.getEmail(), password);
    user.setRoles(roles);
    userRepository.save(user);

    return ResponseHandler.responseData(201, "User successfully added!", user);
  }

  @Override
  public ResponseEntity<?> loginUserService(UserLoginRequest request) {
    User user = userRepository.findByUsername(request.getUsername());
    userValidation.validateUser(user);

    if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
      throw new IllegalArgumentException("Wrong password!");
    }

    // buat userpass token
    UsernamePasswordAuthenticationToken userAuthToken = new UsernamePasswordAuthenticationToken(user.getUsername(),
        request.getPassword());

    // auth user
    Authentication authentication = authenticationManager.authenticate(userAuthToken);

    // buat security context holder
    SecurityContextHolder.getContext().setAuthentication(authentication);

    String token = jwtUtil.createToken(request.getUsername());

    Map<String, Object> data = new HashMap<>();
    data.put("username", user.getUsername());
    data.put("token", token);

    return ResponseHandler.responseData(200, "Login success!", data);
  }

  @Override
  public ResponseEntity<?> resetPassUserService(UserResetPassRequest request) {
    User user = userRepository.findByUsername(request.getUsername());
    userValidation.validateUser(user);

    if (passwordEncoder.matches(request.getNewPassword(), user.getPassword())) {
      throw new IllegalArgumentException("Your new password same with your old password!");
    }

    String password = passwordEncoder.encode(request.getNewPassword());
    user.setPassword(password);
    userRepository.save(user);

    return ResponseHandler.responseData(200, "Password successfully changed!", user);

  }

  @Override
  public ResponseEntity<?> getUsersService(Boolean isDeleted) {
    List<User> users;
    if (isDeleted == null) {
      users = userRepository.findAll();
    } else {
      users = userRepository.findByIsDeleted(isDeleted);
    }

    return ResponseHandler.responseData(200, "Show all users!", users);
  }

  @Override
  public ResponseEntity<?> getUserByUsernameService(String username) {
    User user = userRepository.findByUsername(username);
    userValidation.validateUser(user);

    return ResponseHandler.responseData(200, "Show user details!", user);
    // return ResponseHandler.responseMessage(200, "Show user details!");
  }

  @Override
  public ResponseEntity<?> updateUserByUsernameService(UpdateUserRequest request, String username) {
    User user = userRepository.findByUsername(username);
    userValidation.validateUser(user);
    userValidation.validateUpdateUser(user, request);
    userRepository.save(user);

    return ResponseHandler.responseData(200, "Successfuly update user details!", user);
  }

  @Override
  public ResponseEntity<?> deleteUserByUsernameService(String username) {
    User user = userRepository.findByUsername(username);
    userValidation.validateUser(user);
    user.setIsDeleted(true);
    userRepository.save(user);

    return ResponseHandler.responseMessage(200, "Successfuly delete user!");
  }

}

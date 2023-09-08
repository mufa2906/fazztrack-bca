package com.example.dailynews.services.user;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
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
import com.example.dailynews.payloads.req.UserLoginRequest;
import com.example.dailynews.payloads.req.UserRegisRequest;
import com.example.dailynews.payloads.req.UserResetPassRequest;
import com.example.dailynews.payloads.res.ResponseHandler;
import com.example.dailynews.repositories.RoleRepository;
import com.example.dailynews.repositories.UserRepository;

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

  @Override
  public ResponseEntity<?> regisUserService(UserRegisRequest request, String role) {
    if (userRepository.existsByUsername(request.getUsername())) {
      throw new IllegalArgumentException("Username already registered!");
    }

    if (userRepository.existsByEmail(request.getEmail())) {
      throw new IllegalArgumentException("Email already registered!");
    }

    String password = passwordEncoder.encode(request.getPassword());

    String strRole = (role.equals(null) || role.equals("") || !role.substring(0, 5).equals("ROLE_")) ? "ROLE_USER" : role;

    Role roleUser = roleRepository.findByName(strRole);
    if(Objects.isNull(roleUser)){
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
    if (!userRepository.existsByUsername(request.getUsername())) {
      throw new NoSuchElementException("Username belum melakukan registrasi");
    }

    User user = userRepository.findByUsername(request.getUsername());

    if (user.getIsDeleted()) {
      throw new NoSuchElementException("Username already deleted!");
    }

    if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
      throw new IllegalArgumentException("Wrong password!");
    }

    //buat userpass token
    UsernamePasswordAuthenticationToken userAuthToken = new UsernamePasswordAuthenticationToken(user.getUsername(), request.getPassword());

    //auth user
    Authentication authentication = authenticationManager.authenticate(userAuthToken);

    //buat security context holder
    SecurityContextHolder.getContext().setAuthentication(authentication);

    String token = jwtUtil.createToken(request.getUsername());

    Map<String, Object> data = new HashMap<>();
    data.put("username",user.getUsername());
    data.put("token",token);

    return ResponseHandler.responseData(200, "Login success!", data);
  }

  @Override
  public ResponseEntity<?> resetPassUserService(UserResetPassRequest request) {

    User user = userRepository.getUsernameOrEmail(request.getUsernameOrEmail()).orElseThrow(() -> {
      throw new NoSuchElementException("Username/Email has not registered yet!");
    });
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
  public ResponseEntity<?> getUserByIdService(String id) {
    User user = userRepository.findById(id).orElseThrow(() -> {
      throw new NoSuchElementException("Username/Email has not registered yet!");
    });

    return ResponseHandler.responseData(200, "Show user details!", user);
    // return ResponseHandler.responseMessage(200, "Show user details!");
  }

  

}

package id.tokobukufarhan.library.services.user;

import java.util.Base64;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import id.tokobukufarhan.library.configs.JwtUtil;
import id.tokobukufarhan.library.models.Role;
import id.tokobukufarhan.library.models.User;
import id.tokobukufarhan.library.payloads.req.UserLoginRequest;
import id.tokobukufarhan.library.payloads.req.UserRegistRequest;
import id.tokobukufarhan.library.payloads.res.ResponseHandler;
import id.tokobukufarhan.library.repositories.RoleRepository;
import id.tokobukufarhan.library.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {
  @Autowired
  UserRepository userRepository;

  @Autowired
  RoleRepository roleRepository;

  @Autowired
  PasswordEncoder passwordEncoder;

  @Autowired
  AuthenticationManager authenticationManager;

  @Autowired
  JwtUtil jwtUtil;

  @Override
  public ResponseEntity<?> RegisUserService(UserRegistRequest request, String role) {

    if (userRepository.existsByEmail(request.getEmail())) {
      throw new IllegalArgumentException("Email already registered");
    }

    if (userRepository.existsByUsername(request.getUsername())) {
      throw new IllegalArgumentException("Username already registered");
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

    User user = new User(request.getUsername(),request.getFullname(), request.getEmail(), password);
    user.setRoles(roles);
    userRepository.save(user);

    // return ResponseHandler.responseMessage(201, "User successfully created!",
    // true);
    return ResponseHandler.responseData(201, "User successfully created!", user);
  }

  // @Override
  public ResponseEntity<?> addUserServiceNoHash(UserRegistRequest request) {

    if (userRepository.existsByUsername(request.getUsername())) {
      throw new IllegalArgumentException("Username already registered");
    }

    User user = new User(request.getUsername(),request.getFullname(), request.getEmail(), request.getPassword());

    userRepository.save(user);

    return ResponseHandler.responseData(HttpStatus.CREATED.value(), "User successfully added!", user);
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

  @Override
  public ResponseEntity<?> getUserByIdService(String id) {
    User user = userRepository.findById(id).orElseThrow(() -> {
      throw new NoSuchElementException("User is not found");
    });

    return ResponseHandler.responseData(200, "User successfully find", user);

  }

  @Override
  public ResponseEntity<?> getUserLoginService(UserLoginRequest request) {
    // if(!userRepository.existsByUsername(request.getUsername())){
    // throw new NoSuchElementException("Username belum melakukan registrasi");
    // }

    // User user = userRepository.findByUsername(request.getUsername());

    // coba pake cek email/username
    if (!userRepository.existsByEmail(request.getEmail())) {
      throw new NoSuchElementException("Username/Email belum melakukan registrasi");
    }

    User user = userRepository.findByEmail(request.getEmail());

    // if (user.getIsDeleted()) {
    // throw new NoSuchElementException("Username sudah dihapus, tidak bisa
    // digunakan kembali");
    // }

    // // validate password
    if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
    throw new NoSuchElementException("Bad Credentials: Password doesn't match!");
    }

    // kita buat usernamepassword token
    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
        request.getEmail(), request.getPassword());

    // // autentikasi user
    Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);

    // // buatkan security context holdernya
    SecurityContextHolder.getContext().setAuthentication(authentication);

    // generate token jwt.
    // token 3 bag : header, payload, signature

    String token = jwtUtil.createToken(request.getEmail());

    Map<String, Object> data = new HashMap<>();
    data.put("email", user.getEmail());
    data.put("token", token);
    data.put("fullname", user.getFullname());

    // return ResponseHandler.responseMessage(200, "Success login!", true);
    return ResponseHandler.responseData(200, "Success login!", data);
  }

  public ResponseEntity<?> loginUserServiceBasicAuth(UserLoginRequest request) {
    // validate if email user not found
    if (!userRepository.existsByEmail(request.getEmail())) {
      throw new NoSuchElementException("Bad Credentials: Email is not found!");
    }

    User user = userRepository.findByEmail(request.getEmail());
    // validate if user active
    if (user.getIsDeleted()) {
      throw new NoSuchElementException("User is not found or deleted!");
    }

    // validate password
    if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
      throw new NoSuchElementException("Bad Credentials: Password doesn't match!");
    }

    // generate token basic auth.
    // token basic auth => email:password => encode dengan base64

    StringBuffer baseToken = new StringBuffer();
    baseToken.append(user.getEmail());
    baseToken.append(":");
    baseToken.append(user.getPassword());

    String token = Base64.getEncoder().encodeToString(baseToken.toString().getBytes());

    Map<String, Object> data = new HashMap<>();
    data.put("email", user.getEmail());
    data.put("token", token);

    // return ResponseHandler.responseMessage(200, "Success login!", true);
    return ResponseHandler.responseData(200, "Success login!", data);
  }

  // @Override
  public ResponseEntity<?> getUserLoginServiceNoHash(UserLoginRequest request) {
    // if(!userRepository.existsByUsername(request.getUsername())){
    // throw new NoSuchElementException("Username belum melakukan registrasi");
    // }

    // User user = userRepository.findByUsername(request.getUsername());

    // coba pake cek email/username
    if (!userRepository.existsByUsername(request.getEmail())
        && !userRepository.existsByEmail(request.getEmail())) {
      throw new NoSuchElementException("Username/Email belum melakukan registrasi");
    }

    User user = userRepository.getUsernameOrEmail(request.getEmail());

    if (user.getIsDeleted()) {
      throw new NoSuchElementException("Username sudah dihapus, tidak bisa digunakan kembali");
    }

    if (!user.getPassword().equals(request.getPassword())) {
      throw new NoSuchElementException("Password Salah");
    }

    return ResponseHandler.responseData(200, "Login berhasil", null);
  }

}

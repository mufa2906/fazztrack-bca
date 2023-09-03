package id.tokobukufarhan.library.services.user;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import id.tokobukufarhan.library.models.User;
import id.tokobukufarhan.library.payloads.req.UserLoginRequest;
import id.tokobukufarhan.library.payloads.req.UserRegistRequest;
import id.tokobukufarhan.library.payloads.res.ResponseHandler;
import id.tokobukufarhan.library.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {
  @Autowired
  UserRepository userRepository;

  @Override
  public ResponseEntity<?> addUserService(UserRegistRequest request) {

    if(userRepository.existsByUsername(request.getUsername())){
      throw new IllegalArgumentException("Username already registered");
    }

    User user = new User(request.getUsername(), request.getEmail(), request.getPassword());

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
    //   throw new NoSuchElementException("Username belum melakukan registrasi");
    // }

    // User user = userRepository.findByUsername(request.getUsername());

    //coba pake cek email/username
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

    return ResponseHandler.responseData(200, "Login berhasil", null);
  }

}
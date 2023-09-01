package id.tokobukufarhan.library.services.user;

import org.springframework.http.ResponseEntity;

import id.tokobukufarhan.library.payloads.req.UserLoginRequest;
import id.tokobukufarhan.library.payloads.req.UserRegistRequest;

public interface UserService {
  ResponseEntity<?> addUserService(UserRegistRequest request);

  ResponseEntity<?> getUsersService(Boolean isDeleted);

  ResponseEntity<?> getUserByIdService(String id);

  ResponseEntity<?> getUserLoginService(UserLoginRequest request);
}

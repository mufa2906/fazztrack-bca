package id.tokobukufarhan.library.services.user;

import org.springframework.http.ResponseEntity;

import id.tokobukufarhan.library.payloads.req.UserLoginRequest;
import id.tokobukufarhan.library.payloads.req.UserRegistRequest;

public interface UserService {
  ResponseEntity<?> RegisUserService(UserRegistRequest request, String role);

  ResponseEntity<?> getUsersService(Boolean isDeleted);

  ResponseEntity<?> getUserByIdService(String id);

  ResponseEntity<?> getUserLoginService(UserLoginRequest request);
}

package id.tokobukufarhan.library.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import id.tokobukufarhan.library.payloads.req.UserLoginRequest;
import id.tokobukufarhan.library.payloads.req.UserRegistRequest;
import id.tokobukufarhan.library.services.user.UserService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("users")
public class UserController {
  @Autowired
  UserService userService;

  @PostMapping
  public ResponseEntity<?> regisUser(@RequestBody @Valid UserRegistRequest request, @RequestParam(value = "role", defaultValue = "") String role) {
    // try {
      return userService.RegisUserService(request, role);
    // } catch (Exception e) {
    //   return ResponseHandler.responseError(500, e.getMessage(), null);
    // }
  }

  @GetMapping
  @PreAuthorize("hasRole('ADMIN')")
  public ResponseEntity<?> getUsers(@RequestParam(value="deleted", defaultValue = "")  Boolean isDeleted) {
    // try {
      return userService.getUsersService(isDeleted);
    // } catch (Exception e) {
    //   return ResponseHandler.responseError(500, e.getMessage(), null);
    // }
  }
  
  @PostMapping("/login")
  public ResponseEntity<?> loginUser(@RequestBody @Valid UserLoginRequest request) {
    // try {
      return userService.getUserLoginService(request);
    // } catch (Exception e) {
    //   return ResponseHandler.responseError(500, e.getMessage(), null);
    // }
  }
}

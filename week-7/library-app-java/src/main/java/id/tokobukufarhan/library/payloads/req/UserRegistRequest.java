package id.tokobukufarhan.library.payloads.req;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class UserRegistRequest {
  @NotEmpty(message = "Username is required!")
  private String username;
  @NotEmpty(message = "Fullname is required!")
  private String fullname;
  @NotEmpty(message = "Email is required!")
  private String email;
  @NotEmpty(message = "Password is required!")
  private String password;
}

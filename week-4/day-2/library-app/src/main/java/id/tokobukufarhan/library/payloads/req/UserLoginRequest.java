package id.tokobukufarhan.library.payloads.req;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class UserLoginRequest {
  @NotEmpty(message = "Username is required!")
  private String usernameOrEmail;
  @NotEmpty(message = "Password is required!")
  private String password;
}

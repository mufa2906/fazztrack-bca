package id.tokobukufarhan.library.payloads.req;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class UserLoginRequest {
  @NotEmpty(message = "Email is required!")
  private String Email;
  @NotEmpty(message = "Password is required!")
  private String password;
}

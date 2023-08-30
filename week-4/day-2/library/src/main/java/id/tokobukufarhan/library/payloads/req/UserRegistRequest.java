package id.tokobukufarhan.library.payloads.req;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class UserRegistRequest {
  @NotEmpty(message = "Username is required!")
  private String username;
  private String email;
  @NotEmpty(message = "Password is required!")
  private String password;
}

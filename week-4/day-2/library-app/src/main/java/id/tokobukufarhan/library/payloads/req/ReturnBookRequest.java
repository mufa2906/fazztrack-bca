package id.tokobukufarhan.library.payloads.req;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class ReturnBookRequest {
  @NotEmpty(message = "Book Transaction Id is required")
  private String id;
  // @NotEmpty(message = "User username is required")
  // private String userUsername;
}

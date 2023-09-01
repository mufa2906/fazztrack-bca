package id.tokobukufarhan.library.payloads.req;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class BorrowBookRequest {
  @NotEmpty(message = "Book title is required")
  private String bookTitle;
  @NotEmpty(message = "User username is required")
  private String userUsername;
}

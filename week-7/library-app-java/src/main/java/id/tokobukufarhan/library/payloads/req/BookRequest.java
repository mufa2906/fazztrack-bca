package id.tokobukufarhan.library.payloads.req;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class BookRequest {
  @NotEmpty(message = "Title is required!")
  private String title;

  @NotEmpty(message = "URL Image is required!")
  private String urlImage;

  @NotEmpty(message = "Description is required!")
  private String description;

}

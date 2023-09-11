package id.tokobukufarhan.library.validators;

import java.util.NoSuchElementException;
import java.util.Objects;

import org.springframework.stereotype.Component;

import id.tokobukufarhan.library.models.Author;

@Component
public class AuthorValidation {
  public void validateAuthor(Author author) {
    if (author == null || Objects.isNull(author)) {
      throw new NoSuchElementException("Author name is not found");
    }
  }
}

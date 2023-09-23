package id.tokobukufarhan.library.validators;

import java.util.NoSuchElementException;
import java.util.Objects;

import org.springframework.stereotype.Component;

import id.tokobukufarhan.library.models.Book;

@Component
public class BookValidation {
    public void validateBook(Book book) {
    if (book == null || Objects.isNull(book)) {
      throw new NoSuchElementException("Book is not found");
    }

    if(book.getIsDeleted()) {
      throw new NoSuchElementException("Book already borrowed by another user / the book is gone");
    }

  }
}

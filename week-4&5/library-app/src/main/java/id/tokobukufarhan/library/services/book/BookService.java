package id.tokobukufarhan.library.services.book;

import org.springframework.http.ResponseEntity;

import id.tokobukufarhan.library.payloads.req.BookRequest;

public interface BookService {
  ResponseEntity<?> addBookService(BookRequest request);

  ResponseEntity<?> getBooksService(Boolean isDeleted);

  ResponseEntity<?> getBookByIdService(String id);
  
  ResponseEntity<?> updateBookService(String id, BookRequest request);
  
  ResponseEntity<?> deleteBookService(String id);

}

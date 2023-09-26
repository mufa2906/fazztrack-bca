package id.tokobukufarhan.library.controllers.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import id.tokobukufarhan.library.payloads.req.BookRequest;
import id.tokobukufarhan.library.services.book.BookService;
import jakarta.validation.Valid;

@RestController
// @RequestMapping("/books")
public class BookController {
  @Autowired
  BookService bookService;

  @PostMapping("/admin/books")
  public ResponseEntity<?> createBook(@RequestBody @Valid BookRequest request) {
    // try {
      return bookService.addBookService(request);
    // } catch (Exception e) {
    //   return ResponseHandler.responseError(500, e.getMessage(), null);
    // }
  }



  @GetMapping("books/{id}")
  // @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
  public ResponseEntity<?> getBookById(@PathVariable String id) {
    // try {
      return bookService.getBookByIdService(id);
    // } catch (Exception e) {
    //   return ResponseHandler.responseError(500, e.getMessage(), null);
    // }
  }

  @PutMapping("/admin/books/{id}")
  public ResponseEntity<?> updateBookById(@PathVariable String id, @RequestBody @Valid BookRequest request ) {
    // try {
      return bookService.updateBookService(id, request);
    // } catch (Exception e) {
    //   return ResponseHandler.responseError(500, e.getMessage(), null);
    // }
  }

  @DeleteMapping("/admin/books/{id}")
  public ResponseEntity<?> deleteBookById(@PathVariable String id) {
    // try {
      return bookService.deleteBookService(id);
    // } catch (Exception e) {
    //   return ResponseHandler.responseError(500, e.getMessage(), null);
    // }
  }

}

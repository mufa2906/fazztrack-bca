package id.tokobukufarhan.library.controllers.guest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import id.tokobukufarhan.library.services.book.BookService;

@RestController
@RequestMapping("/guest/books")
public class GuestBookController {
  @Autowired
  BookService bookService;

  @GetMapping
  public ResponseEntity<?> getBooks(@RequestParam(value="deleted", defaultValue = "")  Boolean isDeleted) {
    // try {
      return bookService.getBooksService(isDeleted);
    // } catch (Exception e) {
    //   return ResponseHandler.responseError(500, e.getMessage(), null);
    // }
  }

}

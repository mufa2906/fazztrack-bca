package id.tokobukufarhan.library.controllers.admin;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import id.tokobukufarhan.library.services.storageBook.StorageBookService;

@RestController
public class ImageBookController {
  @Autowired
  StorageBookService storageBookService;

  @PostMapping("/admin/files/book")
  public ResponseEntity<?> storeImage(@RequestParam(value = "file") MultipartFile file,
      @RequestParam(value = "bookId") String BookId) throws IOException {
    return storageBookService.storeImage(file, BookId);
  }

  @GetMapping("/files/book/{bookId}")
  public ResponseEntity<?> getImage(@PathVariable String bookId) {
    return storageBookService.loadImage(bookId);
  }

}

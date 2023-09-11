package id.tokobukufarhan.library.services.storageBook;

import java.io.IOException;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import id.tokobukufarhan.library.models.Book;
import id.tokobukufarhan.library.models.ImageBook;
import id.tokobukufarhan.library.payloads.res.ResponseHandler;
import id.tokobukufarhan.library.repositories.BookRepository;
import id.tokobukufarhan.library.repositories.ImageBookRepository;

@Service
public class StorageBookServiceImpl implements StorageBookService {
  @Autowired
  ImageBookRepository imageBookRepository;

  @Autowired
  BookRepository bookRepository;


  @Override
  public ResponseEntity<?> storeImage(MultipartFile file, String bookId) throws IOException {
    //ambil nama gambar
    String imgName = StringUtils.cleanPath(file.getOriginalFilename());

    //cari bukunya
    Book book = bookRepository.findById(bookId).orElseThrow(() -> new NoSuchElementException("Book is not found"));

    //buatkan image buku
    ImageBook imageBook = new ImageBook(imgName, file.getBytes(), book);
    imageBookRepository.save(imageBook); // menyimpan id

    // buatkan sharedUrl
    /*
     * endpoint untuk upload: admin/files/book -> POST
     * endpoint untuk load: /files/book/{uuid} -> GET
     */

     String sharedUrl = ServletUriComponentsBuilder
        .fromCurrentContextPath() //localhost:9090
        .path("/files/book/")
        .path(imageBook.getId()) //id gambar
        .toUriString();


        //set shareUrl di image book
        imageBook.setSharedUrl(sharedUrl);

        return ResponseHandler.responseData(201, "Success store image", imageBook);
  }

  @Override
  public ResponseEntity<?> loadImage(String imageId) {
    ImageBook imageBook = imageBookRepository.findById(imageId).orElseThrow(() -> new NoSuchElementException("Image is not found!"));

    return ResponseEntity.ok()
    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=\"" + imageBook.getImageName() + "\"")
    .body(imageBook.getData());
  }
  
}

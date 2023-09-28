package id.tokobukufarhan.library.services.book;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import id.tokobukufarhan.library.models.Book;
import id.tokobukufarhan.library.payloads.req.BookRequest;
import id.tokobukufarhan.library.payloads.res.ResponseHandler;
import id.tokobukufarhan.library.repositories.AuthorRepository;
import id.tokobukufarhan.library.repositories.BookRepository;
import id.tokobukufarhan.library.repositories.PublisherRepository;
import id.tokobukufarhan.library.validators.AuthorValidation;
import id.tokobukufarhan.library.validators.PublisherValidation;

@Service
public class BookServiceImpl implements BookService {
  @Autowired
  BookRepository bookRepository;

  @Autowired
  AuthorRepository authorRepository;

  @Autowired
  PublisherRepository publisherRepository;

  @Autowired
  AuthorValidation authorValidation;

  @Autowired
  PublisherValidation publisherValidation;

  @Override
  public ResponseEntity<?> addBookService(BookRequest request) {

    if (request.getTitle() == "") {
      throw new IllegalArgumentException("Title cannot be empty");
    }

    if (request.getUrlImage() == "") {
      throw new IllegalArgumentException("URL image cannot be empty");
    }

    if (request.getDescription() == "") {
      throw new IllegalArgumentException("Description cannot be empty");
    }

    Book book = new Book(request.getTitle(), request.getUrlImage(), request.getDescription());

    bookRepository.save(book);

    return ResponseHandler.responseData(HttpStatus.CREATED.value(), "Book successfully added!", book);
  }

  @Override
  public ResponseEntity<?> getBooksService(Boolean isDeleted) {
    List<Book> books;
    if (isDeleted == null) {
      books = bookRepository.findAll();
    } else {
      books = bookRepository.findByIsDeleted(isDeleted);
    }

    return ResponseHandler.responseData(200, "getAll Books succesfully!", books);

  }

  @Override
  public ResponseEntity<?> getBookByIdService(String id) {
    Book book = bookRepository.findById(id).orElseThrow(() -> {
      throw new NoSuchElementException("id is not found");
    });

    return ResponseHandler.responseData(200, "Book successfully find!", book);

  }

  @Override
  public ResponseEntity<?> updateBookService(String id, BookRequest request) {
    Book book = bookRepository.findById(id).orElseThrow(() -> {
      throw new NoSuchElementException("id is not found");
    });

    if (request.getTitle() != "") {
      book.setTitle(request.getTitle());
    }

    if (request.getUrlImage() != "") {
      book.setUrlImage(request.getUrlImage());
    }

    if (request.getDescription() != "") {
      book.setDescription(request.getDescription());
    }

    bookRepository.save(book);

    return ResponseHandler.responseData(200, "Book successfully updated!", book);
  }

  @Override
  public ResponseEntity<?> deleteBookService(String id) {
    Book book = bookRepository.findById(id).orElseThrow(() -> {
      throw new NoSuchElementException("id is not found");
    });

    book.setIsDeleted(true);
    bookRepository.save(book);
    return ResponseHandler.responseData(200, "Book successfully deleted!", null);
  }

}

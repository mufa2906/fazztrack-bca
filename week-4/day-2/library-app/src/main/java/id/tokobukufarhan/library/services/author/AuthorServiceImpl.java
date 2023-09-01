package id.tokobukufarhan.library.services.author;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import id.tokobukufarhan.library.models.Author;
import id.tokobukufarhan.library.payloads.req.AuthorRequest;
import id.tokobukufarhan.library.payloads.res.ResponseHandler;
import id.tokobukufarhan.library.repositories.AuthorRepository;

@Service
public class AuthorServiceImpl implements AuthorService {
  @Autowired
  AuthorRepository authorRepository;

  @Override
  public ResponseEntity<?> addAuthorService(AuthorRequest request) {
    if (request.getName() == null || request.getName() == "") {
      throw new IllegalArgumentException("Name is required");
    }

    Author author = new Author(request.getName(), request.getSocialMedia());

    authorRepository.save(author);

    return ResponseHandler.responseData(HttpStatus.CREATED.value(), "Author successfully added!", author);
  }

  @Override
  public ResponseEntity<?> getAuthorsService() {
    List<Author> authors = authorRepository.findAll();

    return ResponseHandler.responseData(HttpStatus.CREATED.value(), "getAll Authors succesfully!", authors);

  }

  @Override
  public ResponseEntity<?> getAuthorByIdService(String id) {
    if (!authorRepository.existsById(id)) {
      throw new NoSuchElementException("id not found");
    }

    Author author = authorRepository.findById(id).orElseThrow(() -> {
      throw new NoSuchElementException("id is not found");
    });

    return ResponseHandler.responseData(HttpStatus.CREATED.value(), "Author successfully find!", author);
  }

  @Override
  public ResponseEntity<?> updateAuthorByIdService(String id, AuthorRequest request) {
    Author author = authorRepository.findById(id).orElseThrow(() -> {
      throw new NoSuchElementException("id is not found");
    });

    if (request.getName() != "") {
      author.setName(request.getName());
    }

    if (request.getSocialMedia() != "") {
      author.setSocialMedia(request.getSocialMedia());
    }

    authorRepository.save(author);

    return ResponseHandler.responseData(HttpStatus.CREATED.value(), "Author successfully update!", author);
  }

  @Override
  public ResponseEntity<?> deleteAuthorByIdService(String id) {
    Author author = authorRepository.findById(id).orElseThrow(() -> {
      throw new NoSuchElementException("id is not found");
    });

    author.setIsDeleted(true);
    authorRepository.save(author);

    return ResponseHandler.responseData(200, "Author successfully deleted!", null);
  }
  
  @Override
  public ResponseEntity<?> getAuthorByNameService(String name) {
    List<Author> authors = authorRepository.getAuthorByLikeName(name);
  
  
    return ResponseHandler.responseData(HttpStatus.CREATED.value(), "Author successfully get by name!", authors);
  }

}

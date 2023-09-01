package id.tokobukufarhan.library.services.author;

import org.springframework.http.ResponseEntity;

import id.tokobukufarhan.library.payloads.req.AuthorRequest;

public interface AuthorService {
  ResponseEntity<?> addAuthorService(AuthorRequest request);

  ResponseEntity<?> getAuthorsService();

  ResponseEntity<?> getAuthorByIdService(String id);
  
  ResponseEntity<?> updateAuthorByIdService(String id, AuthorRequest request);
  
  ResponseEntity<?> deleteAuthorByIdService(String id);

  ResponseEntity<?> getAuthorByNameService(String name);
  
}

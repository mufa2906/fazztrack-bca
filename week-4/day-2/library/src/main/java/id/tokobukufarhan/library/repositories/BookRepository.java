package id.tokobukufarhan.library.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import id.tokobukufarhan.library.models.Book;

public interface BookRepository extends JpaRepository<Book, String> {
  List<Book> findByIsDeleted(Boolean isDeleted);
  
}

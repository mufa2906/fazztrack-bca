package id.tokobukufarhan.library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import id.tokobukufarhan.library.models.ImageBook;

public interface ImageBookRepository extends JpaRepository<ImageBook, String> {
  
}

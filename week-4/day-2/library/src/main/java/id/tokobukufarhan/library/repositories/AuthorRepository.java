package id.tokobukufarhan.library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import id.tokobukufarhan.library.models.Author;
import java.util.List;


public interface AuthorRepository extends JpaRepository<Author, String>{
  List<Author> findByName(String name);
  
  // List<Author> findByNameContains(String name);
  @Query(value = "select * from authors where name like %?% ", nativeQuery = true)
  List<Author> getAuthorByLikeName(String name);

}

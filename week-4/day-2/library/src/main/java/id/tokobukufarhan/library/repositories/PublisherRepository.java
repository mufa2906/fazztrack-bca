package id.tokobukufarhan.library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import id.tokobukufarhan.library.models.Publisher;
import java.util.List;


public interface PublisherRepository extends JpaRepository<Publisher, String>{
  List<Publisher> findByName(String name);
  
  // List<Publisher> findByNameContains(String name);
  @Query(value = "select * from Publishers where name like %?% ", nativeQuery = true)
  List<Publisher> getPublisherByLikeName(String name);

  List<Publisher> findByIsDeleted(Boolean isDeleted);


}

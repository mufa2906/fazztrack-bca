package id.tokobukufarhan.library.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import id.tokobukufarhan.library.models.User;
public interface UserRepository extends JpaRepository<User, String> {
  List<User> findByIsDeleted(Boolean isDeleted);

  User findByUsername(String username);

  User findByEmail(String email);

  Boolean existsByUsername(String username);
 
  Boolean existsByEmail(String Email);

  //Kalo mau pake query yang findByUsernameOrEmail harus 2 param
  @Query(value = "SELECT * FROM users WHERE username = :usernameOrEmail OR email = :usernameOrEmail ", nativeQuery = true)
  User getUsernameOrEmail(String usernameOrEmail);

}

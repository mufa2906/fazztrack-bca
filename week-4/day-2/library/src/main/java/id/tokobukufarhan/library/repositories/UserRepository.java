package id.tokobukufarhan.library.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import id.tokobukufarhan.library.models.User;

public interface UserRepository extends JpaRepository<User, String> {
  List<User> findByIsDeleted(Boolean isDeleted);

  User findByUsername(String username);

  Boolean existsByUsername(String username);
}

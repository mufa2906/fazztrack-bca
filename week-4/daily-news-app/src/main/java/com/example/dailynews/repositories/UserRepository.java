package com.example.dailynews.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.dailynews.models.User;
import java.util.List;

public interface UserRepository extends JpaRepository<User, String> {
  User findByUsername(String username);

  Boolean existsByUsername(String username);

  User findByEmail(String email);

  Boolean existsByEmail(String email);

  List<User> findByIsDeleted(Boolean isDeleted);

  @Query(value = "SELECT * FROM users WHERE username = :usernameOrEmail OR email = :usernameOrEmail ", nativeQuery = true)
  User getUsernameOrEmail(String usernameOrEmail);
}

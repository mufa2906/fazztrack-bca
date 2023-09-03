package com.example.dailynews.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.dailynews.models.User;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
  Optional<User> findByUsername(String username);

  Optional<User> findByEmail(String email);

  Boolean existsByUsername(String username);

  Boolean existsByEmail(String email);

  List<User> findByIsDeleted(Boolean isDeleted);

  @Query(value = "SELECT * FROM users WHERE username = :usernameOrEmail OR email = :usernameOrEmail ", nativeQuery = true)
  Optional<User> getUsernameOrEmail(String usernameOrEmail);
}

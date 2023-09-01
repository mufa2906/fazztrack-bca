package com.example.dailynews.models;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
  @Id
  @UuidGenerator
  private String id;

  @Column(length = 100, unique = true)
  private String username;

  @Column(unique = true)
  private String email;

  private String password;

  @ManyToOne
  @JoinColumn(name= "role_id")
  private Role role;

  @CreationTimestamp
  private LocalDateTime createdAt;

  @UpdateTimestamp
  private LocalDateTime updatedAt;

  private Boolean isDeleted = false;

  public User(String username, String email, String password, Role role) {
    this.username = username;
    this.email = email;
    this.password = password;
    this.role = role;
  }

}

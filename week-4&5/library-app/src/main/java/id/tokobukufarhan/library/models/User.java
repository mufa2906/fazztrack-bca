package id.tokobukufarhan.library.models;

import java.time.LocalDateTime;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
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

  @Column(length = 100, unique= true)
  private String username;

  @Column(unique= true)
  private String email;

  @JsonIgnore
  private String password;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(
    name = "users_roles", 
    joinColumns = @JoinColumn(name = "user_id"), 
    inverseJoinColumns = @JoinColumn(name = "role_id")
    )
  private Set<Role> roles;
  
  @CreationTimestamp
  private LocalDateTime createdAt;

  @UpdateTimestamp
  private LocalDateTime updatedAt;
  private Boolean isDeleted = false;

  public User(String username, String email, String password) {
    this.username = username;
    this.email = email;
    this.password = password;
  }

}

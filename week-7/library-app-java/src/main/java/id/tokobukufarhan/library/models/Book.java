package id.tokobukufarhan.library.models;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "books")
public class Book {
  @Id
  @UuidGenerator
  private String id;

  @Column
  private String title;

  @Column
  private String urlImage;

  @Column(columnDefinition = "TEXT")
  private String description;

  @CreationTimestamp
  private LocalDateTime createdAt;

  @UpdateTimestamp
  private LocalDateTime updatedAt;
  private Boolean isDeleted = false;
  private Boolean isBorrowed = false;

  public Book(String title, String urlImage, String description) {
    this.title = title;
    this.urlImage = urlImage;
    this.description = description;
  }

}

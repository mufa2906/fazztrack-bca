package id.tokobukufarhan.library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import id.tokobukufarhan.library.models.Book;
import id.tokobukufarhan.library.models.Transaction;
import id.tokobukufarhan.library.models.User;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, String> {
  List<Transaction> findByUser(User user);

  Boolean existsByUser(User user);

  List<Transaction> findByBook(Book book);

  List<Transaction> findByIsDeleted(Boolean isDeleted);
}

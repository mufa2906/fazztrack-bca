package id.tokobukufarhan.library.services.transaction;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import id.tokobukufarhan.library.models.Book;
import id.tokobukufarhan.library.models.Transaction;
import id.tokobukufarhan.library.models.User;
import id.tokobukufarhan.library.payloads.req.BorrowBookRequest;
import id.tokobukufarhan.library.payloads.res.ResponseHandler;
import id.tokobukufarhan.library.repositories.BookRepository;
import id.tokobukufarhan.library.repositories.TransactionRepository;
import id.tokobukufarhan.library.repositories.UserRepository;
import id.tokobukufarhan.library.validators.BookValidation;
import id.tokobukufarhan.library.validators.UserValidation;

@Service
public class TransactionServiceImpl implements TransactionService {
  @Autowired
  TransactionRepository transactionRepository;

  @Autowired
  UserRepository userRepository;

  @Autowired
  BookRepository bookRepository;

  @Autowired
  UserValidation userValidation;

  @Autowired
  BookValidation bookValidation;

  @Override
  public ResponseEntity<?> borrowBookService(BorrowBookRequest request) {
    Book book = bookRepository.findByTitle(request.getBookTitle());
    bookValidation.validateBook(book);

    User user = userRepository.findByUsername(request.getUserUsername());
    userValidation.validateUser(user);

    Transaction transaction = new Transaction(book, user);

    transactionRepository.save(transaction);

    book.setIsDeleted(true);
    bookRepository.save(book);

    Map<String, Object> response = new HashMap<>();
    response.put("transaction_id", transaction.getId());
    response.put("book_title", request.getBookTitle());
    response.put("username", request.getUserUsername());

    return ResponseHandler.responseData(HttpStatus.CREATED.value(), "Peminjaman buku berhasil", response);
  }

  @Override
  public ResponseEntity<?> returnBookService(String id) {
    Transaction transaction = transactionRepository.findById(id).orElseThrow(() -> {
      throw new NoSuchElementException("Peminjaman buku tidak ditemukan");
    });

    if (transaction.getIsDeleted()) {
      throw new NoSuchElementException("Peminjaman buku sudah dikembalikan");
    }
    transaction.setIsDeleted(true);

    transactionRepository.save(transaction);

    Book book = transaction.getBook();

    book.setIsDeleted(false);
    bookRepository.save(book);

    return ResponseHandler.responseData(200, "Pengembalian buku berhasil", transaction);

  }

  @Override
  public ResponseEntity<?> getBookTransactionsService(Boolean isDeleted) {
    List<Transaction> transactions;
    if (isDeleted == null) {
      transactions = transactionRepository.findAll();
    } else {
      transactions = transactionRepository.findByIsDeleted(isDeleted);
    }

    Map<String, Object> response = new HashMap<>();
    int index = 1;
    for (Transaction transaction : transactions) {
      Map<String, Object> data = new HashMap<>();
      data.put("transaction_id", transaction.getId());
      data.put("book_title", transaction.getBook().getTitle());
      data.put("username", transaction.getUser().getUsername());
      data.put("status", transaction.getIsDeleted());
      response.put("transaction_" + index,data);
      index++;
    }

    return ResponseHandler.responseData(200, "Book Transaction succesfully find All ", response);

  }

}

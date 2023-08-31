package id.tokobukufarhan.library.services.transaction;

import org.springframework.http.ResponseEntity;

import id.tokobukufarhan.library.payloads.req.BorrowBookRequest;

public interface TransactionService {
  ResponseEntity<?> borrowBookService(BorrowBookRequest request);

  ResponseEntity<?> returnBookService(String id);

  ResponseEntity<?> getBookTransactionsService(Boolean isDeleted);

}

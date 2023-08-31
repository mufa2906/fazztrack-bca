package id.tokobukufarhan.library.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import id.tokobukufarhan.library.payloads.req.BorrowBookRequest;
import id.tokobukufarhan.library.services.transaction.TransactionService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
  @Autowired
  TransactionService transactionService;

  @PostMapping
  public ResponseEntity<?> borrowBook(@RequestBody @Valid BorrowBookRequest request) {
    // try {
    return transactionService.borrowBookService(request);
  }

  @GetMapping
  public ResponseEntity<?> getTransactions(@RequestParam(value = "deleted", defaultValue = "") Boolean isDeleted) {
    return transactionService.getBookTransactionsService(isDeleted);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> returnBook(@PathVariable String id) {
    return transactionService.returnBookService(id);
  }

}

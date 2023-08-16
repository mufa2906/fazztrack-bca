package services.transaction;

import java.util.List;

import models.Peminjaman;

public interface TransactionService {
  void borrowBook(Peminjaman pinjam);

  void returnBook(Integer id, Peminjaman data);

  List<Peminjaman> getAllTransactions();

  Peminjaman getTransactionById(Integer id);
}

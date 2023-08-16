package services.transaction;

import java.time.LocalDate;
import java.util.List;

import dao.PeminjamanDao;
import exception.TransactionNotFoundException;
import models.Peminjaman;

public class TransactionServiceImpl implements TransactionService {
  PeminjamanDao peminjamanDao;

  public TransactionServiceImpl(PeminjamanDao peminjamanDao) {
    this.peminjamanDao = peminjamanDao;
  }

  @Override
  public void borrowBook(Peminjaman pinjam) {
    pinjam.setTanggalPinjam(LocalDate.now());
    this.peminjamanDao.save(pinjam);
    System.out.println("Peminjaman buku berhasil ditambahkan!");
  }

  @Override
  public void returnBook(Integer id, Peminjaman data) {
    data.setTanggalKembali(LocalDate.now());
    this.peminjamanDao.update(id, data);
    System.out.println("Pengembalian buku berhasil!");
  }

  @Override
  public List<Peminjaman> getAllTransactions() {
    return this.peminjamanDao.findAll();
  }

  @Override
  public Peminjaman getTransactionById(Integer id) {
    if (id > getAllTransactions().size() || id < 1) {
      throw new TransactionNotFoundException("Transaksi Peminjaman Buku tidak ditemukan");
    }
    return this.peminjamanDao.findById(id);
  }

}

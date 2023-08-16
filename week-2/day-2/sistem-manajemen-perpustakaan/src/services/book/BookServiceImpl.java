package services.book;

import java.util.List;

import dao.BukuDao;
import exception.BookNotFoundException;
import exception.EmptyException;
import models.Buku;

public class BookServiceImpl implements BookService {
  BukuDao bukuDao;

  public BookServiceImpl(BukuDao bukuDao) {
    this.bukuDao = bukuDao;
  }

  @Override
  public void addBook(Buku buku) {
    // validasi Apakah buku semua input tidak kosong
    if (buku.getJudul() == "") {
      throw new EmptyException("Judul Buku Masih Kosong");
    }
    if (buku.getPenerbit() == "") {
      throw new EmptyException("Penerbit Buku Masih Kosong");
    }
    if (buku.getPengarang() == "") {
      throw new EmptyException("Pengarang Buku Masih Kosong");
    }
    bukuDao.save(buku);
    System.out.println("Buku berhasil ditambahkan!");
  }

  @Override
  public List<Buku> getAllBook() {
    return bukuDao.findAll();
  }

  @Override
  public Buku getBookById(Integer id) {
    if (id > bukuDao.findAll().size() || id < 1) {
      throw new  BookNotFoundException("Buku tidak ditemukan");
    }
    return bukuDao.findById(id);
  }

  // @Override
  // public void updateBook(Integer id, Buku buku) { 
  //   bukuDao.update(id, buku);
  // }

  // @Override
  // public void deleteBookById(Integer id) {
  //   bukuDao.delete(id);
    
  // }


}

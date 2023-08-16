package services.book;

import java.util.List;

import dao.BukuDao;
import models.Buku;

public class BookServiceImpl implements BookService {
  BukuDao bukuDao;

  public BookServiceImpl(BukuDao bukuDao) {
    this.bukuDao = bukuDao;
  }

  @Override
  public void addBook(Buku buku) {
    // validasi
    if (buku.getJudul() == "") {
      // throw exception judul bukunya masih empty
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
    // validasi id yg diinput misal < 0 atau > size
    // throw exception errornya
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

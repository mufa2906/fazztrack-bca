package library.services.book;

import java.util.List;

import library.dao.BukuDao;
import library.models.Buku;

public class BookServiceImpl implements BookService {
  BukuDao bukuDao;

  public BookServiceImpl(BukuDao bukuDao) {
    this.bukuDao = bukuDao;
  }

  @Override
  public void createBook(Buku buku) {
    // validasi
    if (buku.getJudul() == "") {
      // throw exception judul bukunya masih empty
    }

    bukuDao.save(buku);
    System.out.println("Buku is added!");
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

}

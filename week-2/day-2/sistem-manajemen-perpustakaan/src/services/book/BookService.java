package services.book;

import java.util.List;

import models.Buku;

public interface BookService {
  // CRUD
  void addBook(Buku buku);

  List<Buku> getAllBook();

  Buku getBookById(Integer id);

  // void updateBook(Integer id, Buku buku);

  // void deleteBookById(Integer id);


}

package library.services.book;

import java.util.List;

import library.models.Buku;

public interface BookService {
  // CRUD
  void createBook(Buku buku);

  List<Buku> getAllBook();

  Buku getBookById(Integer id);
}

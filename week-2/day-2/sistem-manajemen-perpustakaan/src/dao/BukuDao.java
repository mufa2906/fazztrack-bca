package dao;

import java.util.ArrayList;
import java.util.List;

import services.BaseDao;
import models.Buku;

public class BukuDao implements BaseDao<Buku, Integer> {
  List<Buku> books = new ArrayList<>();

  @Override
  public void save(Buku data) {
    this.books.add(data);
  }

  @Override
  public List<Buku> findAll() {
    return this.books;
  }

  @Override
  public Buku findById(Integer id) {
    return this.books.get(id - 1);
  }

  @Override
  public void update(Integer id, Buku data) {
    this.books.set(id - 1, data);
  }

  @Override
  public void delete(Integer id) {
    this.books.remove(id - 1);
  }

}

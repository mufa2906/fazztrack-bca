package dao;

import java.util.ArrayList;
import java.util.List;

import models.Peminjaman;
import services.BaseDao;

public class PeminjamanDao implements BaseDao<Peminjaman, Integer> {
  List<Peminjaman> transactions = new ArrayList<>();

  @Override
  public void save(Peminjaman data) {
    this.transactions.add(data);
  }

  @Override
  public List<Peminjaman> findAll() {
    return this.transactions;
  }

  @Override
  public Peminjaman findById(Integer id) {
    return this.transactions.get(id - 1);
  }

  @Override
  public void update(Integer id, Peminjaman data) {
    this.transactions.set(id - 1, data);
  }

  @Override
  public void delete(Integer id) {
    this.transactions.remove(id - 1);  
  }

}

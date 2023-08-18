package dao;

import java.util.ArrayList;
import java.util.List;

import models.Anggota;

public class AnggotaDao implements BaseDao<Anggota, Integer> {
  List<Anggota> users = new ArrayList<>();

  public void save(Anggota data) {
    this.users.add(data);
  }

  @Override
  public List<Anggota> findAll() {
    return this.users;
  }

  @Override
  public Anggota findById(Integer id) {
    return this.users.get(id - 1);
  }

  @Override
  public void update(Integer id, Anggota data) {
    this.users.set(id - 1, data);
  }

  @Override
  public void delete(Integer id) {
    this.users.remove(id - 1);
  }


}

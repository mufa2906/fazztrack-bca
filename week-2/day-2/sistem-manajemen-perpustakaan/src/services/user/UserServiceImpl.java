package services.user;

import java.util.List;

import dao.AnggotaDao;
import models.Anggota;

public class UserServiceImpl implements UserService {
  AnggotaDao userDao;

  public UserServiceImpl(AnggotaDao userDao) {
    this.userDao = userDao;
  }

  @Override
  public void addUser(Anggota user) {
    this.userDao.save(user);
    System.out.println("Anggota berhasil ditambahkan!");
  }

  @Override
  public List<Anggota> getAllUser() {
    return this.userDao.findAll();
  }

  @Override
  public Anggota getUserById(Integer id) {
    return this.userDao.findById(id);
  }

}

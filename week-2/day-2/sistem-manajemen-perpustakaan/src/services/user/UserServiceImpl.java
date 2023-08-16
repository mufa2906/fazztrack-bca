package services.user;

import java.util.List;

import dao.AnggotaDao;
import exception.EmptyException;
import exception.UserNotFoundException;
import models.Anggota;

public class UserServiceImpl implements UserService {
  AnggotaDao userDao;

  public UserServiceImpl(AnggotaDao userDao) {
    this.userDao = userDao;
  }

  @Override
  public void addUser(Anggota user) {
    if (user.getUsername() == "") {
      throw new EmptyException("Username Masih Kosong");
    }
    if (user.getEmail() == "") {
      throw new EmptyException("Email Masih Kosong");
    }
    this.userDao.save(user);
    System.out.println("Anggota berhasil ditambahkan!");
  }

  @Override
  public List<Anggota> getAllUser() {
    return this.userDao.findAll();
  }

  @Override
  public Anggota getUserById(Integer id) {
    if ( id > getAllUser().size() || id < 1){
      throw new UserNotFoundException("Anggota tidak ditemukan");
    }
    return this.userDao.findById(id);
  }

}

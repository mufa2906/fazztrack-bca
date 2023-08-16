package services.user;

import java.util.List;

import models.Anggota;

public interface UserService {
  void addUser(Anggota user);

  List<Anggota> getAllUser();

  Anggota getUserById(Integer id);
}

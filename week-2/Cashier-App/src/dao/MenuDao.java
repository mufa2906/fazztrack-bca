package dao;

import java.util.ArrayList;
import java.util.List;

import models.Menu;

public class MenuDao implements BaseDao<Menu, Integer> {
  List<Menu> menus = new ArrayList<>();

  @Override
  public void add(Menu data) {
    menus.add(data);
  }

  @Override
  public List<Menu> findAll() {
    return menus;
  }

  @Override
  public Menu findById(Integer id) {
    return menus.get(id - 1);
  }

  @Override
  public void update(Integer id, Menu data) {
    menus.set(id - 1, data);
  }

  @Override
  public void delete(Integer id) {
    menus.remove(id - 1);
  }
  
}

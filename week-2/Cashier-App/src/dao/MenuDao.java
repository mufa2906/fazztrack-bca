package dao;

import java.util.ArrayList;
import java.util.List;

import models.Menu;

public class MenuDao implements BaseDao<Menu, Integer> {
  List<Menu> menuList = new ArrayList<>();

  @Override
  public void add(Menu data) {
    menuList.add(data);
  }

  @Override
  public List<Menu> findAll() {
    return menuList;
  }

  @Override
  public Menu findById(Integer id) {
    return menuList.get(id - 1);
  }

  @Override
  public void update(Integer id, Menu data) {
    menuList.set(id - 1, data);
  }

  @Override
  public void delete(Integer id) {
    menuList.remove(id - 1);
  }
  
}

package services.menu;

import java.util.List;

import models.Menu;

public interface MenuService {

  List<Menu> getAllMenu();

  Menu getSingleMenu(Integer id);

  Menu getSingleMenu(Integer id, String jenis);

  void getMenuByJenis(String jenis);

  void addMenu(Menu menu);

  void updateMenu(Integer id, Menu menu);

  void removeMenu(Integer id);

}

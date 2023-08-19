package services.menu;

import java.util.List;

import models.Menu;

public interface MenuService {
  
  List<Menu> getAllMenu();
  
  Menu getSingleMenu(Integer id);
  
  void addMenu(Menu menu);

  void updateMenu(Integer id, Menu menu);

  void removeMenu(Integer id);


}

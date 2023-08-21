package services.menu;

import java.util.List;

import dao.MenuDao;
import models.Menu;

public class MenuServiceImpl implements MenuService {
  MenuDao menuDao;

  public MenuServiceImpl() {
  }

  public MenuServiceImpl(MenuDao menuDao) {
    this.menuDao = menuDao;
  }

  @Override
  public List<Menu> getAllMenu() {
    return menuDao.findAll();
  }

  @Override
  public Menu getSingleMenu(Integer id) {
    return menuDao.findById(id);
  }

  @Override
  public Menu getSingleMenu(Integer idMenu, String jenisMenu) {
    Integer num = 1;
    for (int i = 0; i < getAllMenu().size(); i++) {
      if (getAllMenu().get(i).getJenis().equals(jenisMenu.toLowerCase())) {
        if (num.equals(idMenu)) {
          num = i + 1;
          break;
        }
        num++;
      }
    }
    return menuDao.findById(num);
  }

  @Override
  public void getMenuByJenis(String jenisMenu) {
    System.out.println();
    System.out.println("=== MENU " + jenisMenu.toUpperCase() + " ===");
    Integer num = 1;
    for (int i = 0; i < getAllMenu().size(); i++) {
      if (getAllMenu().get(i).getJenis().equals(jenisMenu.toLowerCase())) {
        System.out.println(num++ + ". " + getAllMenu().get(i).getNama() + " - " + getAllMenu().get(i).getHarga());
      }
    }
  }

  @Override
  public void addMenu(Menu menu) {
    menuDao.add(menu);
    System.out.println("Menu Berhasil Ditambah");
  }

  @Override
  public void updateMenu(Integer id, Menu menu) {
    if (menu.getNama().isEmpty()) {
      menu.setNama(menuDao.findById(id).getNama());
    }
    if (menu.getHarga() == null) {
      menu.setHarga(menuDao.findById(id).getHarga());
    }
    if (menu.getNama().isEmpty()) {
      menu.setNama(menuDao.findById(id).getNama());
    }
    menuDao.update(id, menu);
    System.out.println("Menu Berhasil Diupdate");
  }

  @Override
  public void removeMenu(Integer id) {
    menuDao.delete(id);
    System.out.println("Menu Berhasil Dihapus");
  }

}

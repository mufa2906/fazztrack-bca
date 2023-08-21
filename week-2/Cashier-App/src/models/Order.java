package models;

public class Order{
  private Menu menu;
  private Integer jumlahMenu;
  
  
  public Order() {
  }
  
  public Order(Menu menu, Integer jumlahMenu) {
    this.menu = menu;
    this.jumlahMenu = jumlahMenu;
  }
  
  public Menu getMenu() {
    return menu;
  }
  
  public void setMenu(Menu menu) {
    this.menu = menu;
  }
  
  public Integer getJumlahMenu() {
    return jumlahMenu;
  }
  
  public void setJumlahMenu(Integer jumlahMenu) {
    this.jumlahMenu = jumlahMenu;
  }

  @Override
  public String toString() {
    return "Order [menu=" + menu + ", jumlahMenu=" + jumlahMenu + "]";
  }
  
  

  
  
}

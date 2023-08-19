package models;

public class Order {
  private Menu menu;
  private Integer numberOfMenu;
  
  public Order() {
  }

  public Order(Menu menu, Integer numberOfMenu) {
    this.menu = menu;
    this.numberOfMenu = numberOfMenu;
  }

  public Menu getMenu() {
    return menu;
  }

  public void setMenu(Menu menu) {
    this.menu = menu;
  }

  public Integer getNumberOfMenu() {
    return numberOfMenu;
  }

  public void setNumberOfMenu(Integer numberOfMenu) {
    this.numberOfMenu = numberOfMenu;
  }

  @Override
  public String toString() {
    return "Order [menu=" + menu + ", numberOfMenu=" + numberOfMenu + "]";
  }

  
  
}

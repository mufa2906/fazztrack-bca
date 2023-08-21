package models;

import java.util.List;

public class Payment {
  private List<Order> order;
  private Double price;
  private String status;

  public Payment() {
  }

  public Payment(List<Order> order, Double price, String status) {
    this.order = order;
    this.price = price;
    this.status = status;
  }

  public List<Order> getOrder() {
    return order;
  }

  public void setOrder(List<Order> order) {
    this.order = order;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  @Override
  public String toString() {
    return "Payment [order=" + order + ", price=" + price + ", status=" + status + "]";
  }

  

}

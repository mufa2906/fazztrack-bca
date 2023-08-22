package services.order;

import java.util.List;

import models.Order;

public interface OrderService {
  List<Order> getAllOrder();
  
  Order getSingleOrder(Integer id);
  
  void addOrder(Order order);

  void updateOrder(Integer id, Order order);

  void removeOrder(Integer id);

  Double getPriceOrder();

  Double getTaxPriceOrder();
  
  Double getTotalPriceOrder();

  void getOrderDetail();

  void removeAllOrder();
}

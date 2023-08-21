package dao;

import java.util.ArrayList;
import java.util.List;

import models.Order;

public class OrderDao implements BaseDao<Order, Integer> {
  List<Order> orderList = new ArrayList<>();

  @Override
  public void add(Order data) {
    orderList.add(data);
  }

  @Override
  public List<Order> findAll() {
    return orderList;
  }

  @Override
  public Order findById(Integer id) {
    return orderList.get(id - 1);
  }

  @Override
  public void update(Integer id, Order data) {
    orderList.set(id - 1, data);
  }

  @Override
  public void delete(Integer id) {
    orderList.remove(id - 1);
  }
}

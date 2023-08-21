package services.order;

import java.util.List;

import dao.OrderDao;
import models.Order;

public class OrderServiceImpl implements OrderService {
  OrderDao orderDao;
  Double orderPrice = 0.0;

  public OrderServiceImpl() {
  }

  public OrderServiceImpl(OrderDao orderDao) {
    this.orderDao = orderDao;
  }

  @Override
  public List<Order> getAllOrder() {
    return orderDao.findAll();
  }

  @Override
  public Order getSingleOrder(Integer id) {
    return orderDao.findById(id);
  }

  @Override
  public void addOrder(Order order) {
    orderDao.add(order);
    System.out.println("Pemesanan Berhasil dilakukan");
  }

  @Override
  public void updateOrder(Integer id, Order order) {
    orderDao.update(id, order);
    System.out.println("Pemesanan Berhasil Diupdate");
  }

  @Override
  public void removeOrder(Integer id) {
    orderDao.delete(id);
    System.out.println("Pemesanan Berhasil Dihapus");
  }

  @Override
  public Double getPriceOrder() {
    for (int i = 0; i < getAllOrder().size(); i++) {
      orderPrice += getAllOrder().get(i).getMenu().getHarga();
    }

    return orderPrice;
  }

  @Override
  public void getOrderDetail() {
    for (int i = 0; i < getAllOrder().size(); i++) {
      System.out.println(1 + i + ". " + getAllOrder().get(i).getMenu().getJenis() + ": " + getAllOrder().get(i).getMenu().getNama());
      System.out.println("   " + getAllOrder().get(i).getJumlahMenu() + " X " + getAllOrder().get(i).getMenu().getHarga() + " : "
          + (getAllOrder().get(i).getJumlahMenu() * getAllOrder().get(i).getMenu().getHarga()));
    }
    System.out.println("Total harga setelah PPN (11%): " + getPriceOrder()*111/100);
  }

}

package services.order;

import java.util.List;

import dao.OrderDao;
import exceptions.EmptyNumberOfOrder;
import exceptions.OrderNotFoundException;
import models.Order;

public class OrderServiceImpl implements OrderService {
  OrderDao orderDao;
  Double orderTax = 0.11;
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
    if (id < 1 || id > getAllOrder().size()) {
      throw new OrderNotFoundException("Pesanan tidak ditemukan");
    }
    return orderDao.findById(id);
  }

  @Override
  public void addOrder(Order order) {
    if (order.getJumlahMenu() == null) {
      throw new EmptyNumberOfOrder("Jumlah pesanan harus diisi");
    }
    orderDao.add(order);
    System.out.println("Pemesanan Berhasil dilakukan");
  }

  @Override
  public void updateOrder(Integer id, Order order) {
    if (order.getJumlahMenu() == null) {
      throw new EmptyNumberOfOrder("Jumlah pesanan harus diisi");
    }
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
    orderPrice = 0.0;
    for (int i = 0; i < getAllOrder().size(); i++) {
      orderPrice += (getAllOrder().get(i).getJumlahMenu() * getAllOrder().get(i).getMenu().getHarga());
    }

    return orderPrice;
  }

  @Override
  public Double getTaxPriceOrder() {
    return orderPrice * orderTax;
  }

  @Override
  public Double getTotalPriceOrder() {
    return getPriceOrder() + getTaxPriceOrder();
  }

  @Override
  public void getOrderDetail() {
    for (int i = 0; i < getAllOrder().size(); i++) {
      System.out.println(
          1 + i + ". " + getAllOrder().get(i).getMenu().getJenis() + ": " + getAllOrder().get(i).getMenu().getNama());
      System.out.println(
          "   " + getAllOrder().get(i).getJumlahMenu() + " X " + getAllOrder().get(i).getMenu().getHarga() + " : "
              + (getAllOrder().get(i).getJumlahMenu() * getAllOrder().get(i).getMenu().getHarga()));
    }
    System.out.println("Total harga: " + getPriceOrder());
    System.out.println("PPN (11%): " + getTaxPriceOrder());
    System.out.println("Total harga setelah PPN (11%): " + getTotalPriceOrder());
  }

}

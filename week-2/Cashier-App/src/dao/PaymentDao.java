package dao;

import java.util.ArrayList;
import java.util.List;

import models.Payment;

public class PaymentDao implements BaseDao<Payment, Integer> {
  List<Payment> paymentList = new ArrayList<>();

  @Override
  public void add(Payment data) {
    paymentList.add(data);
  }

  @Override
  public List<Payment> findAll() {
    return paymentList;
  }

  @Override
  public Payment findById(Integer id) {
    return paymentList.get(id - 1);
  }

  @Override
  public void update(Integer id, Payment data) {
    paymentList.set(id - 1, data);
  }

  @Override
  public void delete(Integer id) {
    paymentList.remove(id - 1);
  }
  
}

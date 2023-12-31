package services.payment;

import java.time.LocalDateTime;
import java.util.List;

import dao.PaymentDao;
import models.Payment;

public class PaymentServiceImpl implements PaymentService {
  PaymentDao paymentDao;

  public PaymentServiceImpl() {
  }

  public PaymentServiceImpl(PaymentDao paymentDao) {
    this.paymentDao = paymentDao;
  }

  @Override
  public void addPayment(Payment payment) {
    paymentDao.add(payment);
    System.out.println();
    System.out.println("=== BUKTI PEMBAYARAN ===");
    LocalDateTime tanggal = LocalDateTime.now();
    System.out.println(tanggal);
  }

  @Override
  public List<Payment> getAllPayment() {
    return paymentDao.findAll();
  }
}

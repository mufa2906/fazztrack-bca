package services.payment;


import java.util.List;

import models.Payment;

public interface PaymentService {

  void addPayment(Payment payment);

  List<Payment> getAllPayment();
}


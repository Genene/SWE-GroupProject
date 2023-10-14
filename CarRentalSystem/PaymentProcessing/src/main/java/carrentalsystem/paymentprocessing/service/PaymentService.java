package carrentalsystem.paymentprocessing.service;

import carrentalsystem.paymentprocessing.model.Payment;

import java.util.List;
import java.util.Optional;

public interface PaymentService {
    Payment savePayment(Payment payment);
    Payment findPaymentById(Long paymentId);
    List<Payment> findAllPayments();
    Payment cancelPayment(Long paymentId);
    Payment refundPayment(Long paymentId);
    Payment updatePayment(Payment payment,Long paymentId);

}

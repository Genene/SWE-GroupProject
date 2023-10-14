package carrentalsystem.paymentprocessing.service.impl;

import carrentalsystem.paymentprocessing.model.Payment;
import carrentalsystem.paymentprocessing.model.enums.PaymentStatus;
import carrentalsystem.paymentprocessing.repository.PaymentRepository;
import carrentalsystem.paymentprocessing.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;



@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository paymentRepository;
    @Override
    public Payment savePayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public Payment findPaymentById(Long paymentId) {
        return paymentRepository.findById(paymentId).orElseThrow(()->new RuntimeException("Payment with id "+paymentId+" not found"));
    }

    @Override
    public List<Payment> findAllPayments() {
        if (paymentRepository.findAll().isEmpty())
            throw new RuntimeException("No payments found");
        return paymentRepository.findAll();
    }

    @Override
    public Payment cancelPayment(Long paymentId) {
        Payment payment = paymentRepository.findById(paymentId).orElseThrow(()->new RuntimeException("Payment with id "+paymentId+" not found"));
        payment.setPaymentStatus(PaymentStatus.CANCELLED);
        return paymentRepository.save(payment);
    }

    @Override
    public Payment refundPayment(Long paymentId) {
        Payment payment = paymentRepository.findById(paymentId).orElseThrow(()->new RuntimeException("Payment with id "+paymentId+" not found"));
        payment.setPaymentStatus(PaymentStatus.REFUNDED);
        return paymentRepository.save(payment);
    }

    @Override
    public Payment updatePayment(Payment payment,Long paymentId) {
        Payment existingPayment = paymentRepository.findById(paymentId).orElseThrow(()->new RuntimeException("Payment with id "+paymentId+" not found"));
        existingPayment.setPaymentMethod(payment.getPaymentMethod());
        existingPayment.setPaymentStatus(payment.getPaymentStatus());
        existingPayment.setAmount(payment.getAmount());
        existingPayment.setPaymentDate(payment.getPaymentDate());
        existingPayment.setPaymentTime(payment.getPaymentTime());
        existingPayment.setPaymentType(payment.getPaymentType());
        existingPayment.setPaymentDescription(payment.getPaymentDescription());
        existingPayment.setPaymentCurrency(payment.getPaymentCurrency());
        existingPayment.setPaymentReference(payment.getPaymentReference());
        existingPayment.setPaymentMode(payment.getPaymentMode());
        existingPayment.setPaymentChannel(payment.getPaymentChannel());
        existingPayment.setPaymentChannelProvider(payment.getPaymentChannelProvider());
        existingPayment.setPaymentChannelProviderCountry(payment.getPaymentChannelProviderCountry());
        return paymentRepository.save(existingPayment);

    }

    @Autowired
    public PaymentServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }
}

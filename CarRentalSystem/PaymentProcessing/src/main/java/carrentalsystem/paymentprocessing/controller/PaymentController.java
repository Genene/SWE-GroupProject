package carrentalsystem.paymentprocessing.controller;


import carrentalsystem.paymentprocessing.model.Payment;
import carrentalsystem.paymentprocessing.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/payments")
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping(value = "/process")
    public ResponseEntity<?> processPayment(Payment payment) {
        try {
            return new ResponseEntity<>(paymentService.savePayment(payment), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/list")
    public ResponseEntity<?> listPayments() {
        try {
            return new ResponseEntity<>(paymentService.findAllPayments(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getPaymentById(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(paymentService.findPaymentById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value="/{id}/cancel")
    public ResponseEntity<?> cancelPaymentById(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(paymentService.cancelPayment(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value="/{id}/refund")
    public ResponseEntity<?> refundPaymentById(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(paymentService.refundPayment(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(value="/{id}/update")
    public ResponseEntity<?> updatePaymentById(Payment payment, @PathVariable Long id) {
        try{
            return new ResponseEntity<>(paymentService.updatePayment(payment, id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

}

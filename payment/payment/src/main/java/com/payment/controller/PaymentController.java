package com.payment.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
 
import com.payment.entity.Payment;
import com.payment.service.PaymentService;
 
 
@RestController
@RequestMapping("/payments")
public class PaymentController {
	@Autowired
    private final PaymentService paymentService;
 
    
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }
 
//    @PostMapping("/post")
//    public ResponseEntity<String> createPayment(@RequestParam Long customerId, @RequestParam Double amount) {
//        Payment processedPayment = paymentService.makePayment(customerId, amount);
//        return ResponseEntity.status(HttpStatus.CREATED)
//                             .body("Payment processed successfully: " + processedPayment.getId());
//    }
    @PostMapping("/post")
    public ResponseEntity<String> createPayment(@RequestBody Payment payment) {
        Payment processedPayment = paymentService.makePayment(payment.getCustomerId(), payment.getAmount());
        return ResponseEntity.status(HttpStatus.CREATED)
                             .body("Payment processed successfully: " + processedPayment.getId());
    }
 
 
    @GetMapping("/{id}")
    public ResponseEntity<Payment> getPayment(@PathVariable Long id) {
        Payment payment = paymentService.getPayment(id);
        if (payment != null) {
            return ResponseEntity.ok(payment);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}

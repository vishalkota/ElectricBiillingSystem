package com.payment.service;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
 
import com.payment.entity.Payment;
import com.payment.repository.PaymentRepository;
 
 
@Service
public class PaymentService {
 
    private final PaymentRepository paymentRepository;
 
    @Autowired
    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }
    

 
    public Payment makePayment(Long customerId, Double amount) {
        Payment payment = new Payment();
        payment.setCustomerId(customerId);
        payment.setAmount(amount);
        payment.setPaymentDate(LocalDate.now());
        payment.setStatus("COMPLETED"); // Assuming payment is completed
 
        return paymentRepository.save(payment); // Save the payment
    }
 
    public Payment getPayment(@PathVariable Long paymentId) {
        return paymentRepository.findById(paymentId).orElse(null);
    }
    
    
   
}
 
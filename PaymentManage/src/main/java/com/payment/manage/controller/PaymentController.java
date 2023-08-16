package com.payment.manage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payment.manage.mdel.Payment;
import com.payment.manage.repository.PaymentRepository;

@RestController
@CrossOrigin
@RequestMapping("/cafe/payment")
public class PaymentController {
	
	@Autowired
	private PaymentRepository paymentRepository;

	
	@PostMapping
    public Payment processPayment(@RequestBody Payment payment) {
        try{
        	System.out.println("Payment processed successfully");
        	return paymentRepository.save(payment);
        } catch(Exception e) {
        	System.out.println("Failed to process payment");
		}
		return payment;
    }

    @GetMapping("/{id}")
    public Payment getPaymentById(@PathVariable String id) {
    	try {
    		System.out.println("Payment get by id successfully");
        return paymentRepository.findById(id).orElse(null);
    	} catch (Exception e) {
    		System.out.println("Failed to get payment by id");
    	}
		return null;
    }

    @GetMapping("/order/{orderId}")
    public List<Payment> getPaymentsByOrderId(@PathVariable String orderId) {
    	try {
    		System.out.println("Payment by order id is successful");
        return paymentRepository.findByOrderId(orderId);
    	} catch (Exception e) {
    		System.out.println("Failed to payment by order id");
    	}
		return null;
    }

    @PutMapping("/{id}/status")
    public Payment updatePaymentStatus(@PathVariable String id, @RequestBody String status) {
    	try {
    		System.out.println("Payment status is updated successfully");
        Payment payment = paymentRepository.findById(id).orElse(null);
        if (payment != null) {
            payment.setStatus(status);
            return paymentRepository.save(payment);
        }
        return null;
    	} catch(Exception e) {
    		System.out.println("Failed to update payment status");
    	}
		return null;
    }

}

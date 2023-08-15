package com.payment.management.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payment.management.model.Payment;
import com.payment.management.repository.PaymentRepository;

@RestController
@CrossOrigin
@RequestMapping("/api/payment")
public class PaymentController {
	
	@Autowired
	private PaymentRepository paymentRepository;

    Logger logger = LoggerFactory.getLogger(PaymentController.class);
	
	@PostMapping
    public Payment processPayment(@RequestBody Payment payment) {
        try{
        	logger.info("Payment processed successfully");
        	return paymentRepository.save(payment);
        } catch(Exception e) {
			logger.error("Failed to process payment",e);
		}
		return payment;
    }

    @GetMapping("/{id}")
    public Payment getPaymentById(@PathVariable String id) {
    	try {
    		logger.info("Payment get by id successfully");
        return paymentRepository.findById(id).orElse(null);
    	} catch (Exception e) {
    		logger.error("Failed to get payment by id", e);
    	}
		return null;
    }

    @GetMapping("/order/{orderId}")
    public List<Payment> getPaymentsByOrderId(@PathVariable String orderId) {
    	try {
    		logger.info("Payment by order id is successful");
        return paymentRepository.findByOrderId(orderId);
    	} catch (Exception e) {
    		logger.error("Failed to payment by order id", e);
    	}
		return null;
    }

    @PutMapping("/{id}/status")
    public Payment updatePaymentStatus(@PathVariable String id, @RequestBody String status) {
    	try {
    		logger.info("Payment status is updated successfully");
        Payment payment = paymentRepository.findById(id).orElse(null);
        if (payment != null) {
            payment.setStatus(status);
            return paymentRepository.save(payment);
        }
        return null;
    	} catch(Exception e) {
    		logger.error("Failed to update payment status");
    	}
		return null;
    }

}

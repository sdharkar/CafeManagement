package com.payment.management.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.payment.management.model.Payment;

@Repository
public interface PaymentRepository extends MongoRepository<Payment, String>{

	List<Payment> findByOrderId(String orderId);

}

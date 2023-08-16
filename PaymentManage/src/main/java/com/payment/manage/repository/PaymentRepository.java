package com.payment.manage.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.payment.manage.mdel.Payment;

@Repository
public interface PaymentRepository extends MongoRepository<Payment, String> {

	List<Payment> findByOrderId(String orderId);

}

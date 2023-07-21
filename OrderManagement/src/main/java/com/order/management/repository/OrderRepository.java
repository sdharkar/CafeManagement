package com.order.management.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.order.management.model.Order;

@Repository
public interface OrderRepository extends MongoRepository<Order, String>{

	List<Order> findByUserId(String userId);

}

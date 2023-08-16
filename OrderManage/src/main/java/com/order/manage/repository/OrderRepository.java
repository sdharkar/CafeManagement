package com.order.manage.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.order.manage.model.Order;

@Repository
public interface OrderRepository extends MongoRepository<Order, String> {

	List<Order> findByUserId(String userName);

}

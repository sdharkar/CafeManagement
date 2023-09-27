package com.cafe.management.Repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cafe.management.model.Order;

@Repository
public interface OrderRepo extends MongoRepository<Order, Long>{

	List<Order> findByUsername(String username);

}

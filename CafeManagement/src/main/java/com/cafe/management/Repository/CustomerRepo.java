package com.cafe.management.Repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cafe.management.model.Customer;

@Repository
public interface CustomerRepo extends MongoRepository<Customer, Long>{

	List<Customer> findByName(String name);

}

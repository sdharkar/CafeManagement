package com.order.manage.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.order.manage.model.User;

public interface UserRepository extends MongoRepository<User, String>{

}

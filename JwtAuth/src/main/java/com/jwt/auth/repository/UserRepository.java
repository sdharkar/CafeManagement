package com.jwt.auth.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.jwt.auth.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

}

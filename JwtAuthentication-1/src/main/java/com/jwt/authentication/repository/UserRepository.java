package com.jwt.authentication.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.jwt.authentication.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}

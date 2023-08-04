package com.jwt.auth.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.jwt.auth.model.Role;

@Repository
public interface RoleRepository extends MongoRepository<Role, String>{

}

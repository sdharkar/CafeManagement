package com.user.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.user.model.Role;

@Repository
public interface RoleRepository extends MongoRepository<Role, Integer>{

}

package com.user.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.user.model.Menu;


@Repository
public interface MenuRepository extends MongoRepository<Menu, String>{

}

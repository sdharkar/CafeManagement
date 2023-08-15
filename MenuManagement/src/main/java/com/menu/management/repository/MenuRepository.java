package com.menu.management.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.menu.management.model.Menu;

@Repository
public interface MenuRepository extends MongoRepository<Menu, String>{

}

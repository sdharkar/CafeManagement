package com.order.manage.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.order.manage.model.Menu;

public interface MenuRepository extends MongoRepository<Menu, String>{

}

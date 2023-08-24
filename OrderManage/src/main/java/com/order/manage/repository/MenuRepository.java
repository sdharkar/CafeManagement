package com.order.manage.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.order.manage.model.Menu;

@Repository
public interface MenuRepository extends MongoRepository<Menu, String> {

}

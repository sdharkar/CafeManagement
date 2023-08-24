package com.menu.management.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.menu.management.model.Menu;

@Repository
public interface MenuRepository extends MongoRepository<Menu, String> {

	Optional<Menu> findByName(String name);

}

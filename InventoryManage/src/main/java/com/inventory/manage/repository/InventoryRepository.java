package com.inventory.manage.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.inventory.manage.model.Inventory;

@Repository
public interface InventoryRepository extends MongoRepository<Inventory, String>{

}

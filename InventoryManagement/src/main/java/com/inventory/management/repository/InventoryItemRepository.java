package com.inventory.management.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.inventory.management.model.InventoryItem;

@Repository
public interface InventoryItemRepository extends MongoRepository<InventoryItem, String>{

}

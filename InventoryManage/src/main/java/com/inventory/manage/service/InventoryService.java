package com.inventory.manage.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.manage.model.Inventory;
import com.inventory.manage.repository.InventoryRepository;

@Service
public class InventoryService {
	
	@Autowired
	private InventoryRepository inventoryRepository;
	
	public Inventory createInventoryItem(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    public List<Inventory> getAllInventoryItems() {
        return inventoryRepository.findAll();
    }

    public Optional<Inventory> getInventoryItemById(String id) {
        return inventoryRepository.findById(id);
    }

    public Inventory updateInventoryItem(String id, Inventory inventory) {
        inventory.setId(id);
        return inventoryRepository.save(inventory);
    }

    public void deleteInventoryItem(String id) {
        inventoryRepository.deleteById(id);
    }

}

package com.inventory.management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.management.model.InventoryItem;
import com.inventory.management.repository.InventoryItemRepository;

@Service
public class InventoryItemService {
	
	@Autowired
	private InventoryItemRepository inventoryItemRepository;
	
	public InventoryItem createInventoryItem(InventoryItem inventoryItem) {
        return inventoryItemRepository.save(inventoryItem);
    }

    public List<InventoryItem> getAllInventoryItems() {
        return inventoryItemRepository.findAll();
    }

    public Optional<InventoryItem> getInventoryItemById(String id) {
        return inventoryItemRepository.findById(id);
    }

    public InventoryItem updateInventoryItem(String id, InventoryItem inventoryItem) {
        inventoryItem.setId(id);
        return inventoryItemRepository.save(inventoryItem);
    }

    public void deleteInventoryItem(String id) {
        inventoryItemRepository.deleteById(id);
    }

}

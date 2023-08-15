package com.inventory.manage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.manage.model.Inventory;
import com.inventory.manage.repository.InventoryRepository;

@RestController
@CrossOrigin
@RequestMapping("/cafe/inventory/item")
public class InventoryController {
	
	@Autowired
    private InventoryRepository inventoryRepository;
	
    @PostMapping
    public Inventory createInventoryItem(@RequestBody Inventory inventoryItem) {
    	try {
    		System.out.println("Inventory item created successfully");
    		return inventoryRepository.save(inventoryItem);
    	} catch(Exception e) {
    		System.out.println("Failed to create inventory item");
    	}
		return inventoryItem;
    }

    @GetMapping
    public List<Inventory> getAllInventoryItems() {
    	try {
    		System.out.println("Inventory item got successfully");
    		 return inventoryRepository.findAll();
    	} catch(Exception e) {
    		System.out.println("Failed to get inventory item");
    	}
		return null;
       
    }

    @GetMapping("/{id}")
    public Inventory getInventoryItemById(@PathVariable String id) {
    	try {
    		System.out.println("Inventory item by id got successfully");
    		return inventoryRepository.findById(id).orElse(null);
    	} catch(Exception e) {
    		System.out.println("Failed to get inventory item by id");
    	}
		return null;
        
    }

    @PutMapping("/{id}")
    public Inventory updateInventoryItem(@PathVariable String id, @RequestBody Inventory inventory) {
    	try {
    		System.out.println("Inventory item updated successfully");
    		inventory.setId(id);
            return inventoryRepository.save(inventory);
    	} catch(Exception e) {
    		System.out.println("Failed to update inventory item");
    	}
		return inventory;
        
    }

    @DeleteMapping("/{id}")
    public void deleteInventoryItem(@PathVariable String id) {
    	try {
    		System.out.println("Inventory item deleted successfully");
    		inventoryRepository.deleteById(id);
    	} catch(Exception e) {
    		System.out.println("Failed to delete inventory item");
    	}
    }

}

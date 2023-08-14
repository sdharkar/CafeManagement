package com.inventory.management.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import com.inventory.management.model.InventoryItem;
import com.inventory.management.repository.InventoryItemRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin
@RequestMapping("/api/inventory/item")
@Api(tags = "Inventory API")
public class InventoryController {
	
	@Autowired
    private InventoryItemRepository inventoryItemRepository;
	
	Logger logger = LoggerFactory.getLogger(InventoryController.class);

    @PostMapping
    @ApiOperation("Create a inventory item")
    public InventoryItem createInventoryItem(@RequestBody InventoryItem inventoryItem) {
    	try {
    		logger.info("Inventory item created successfully");
    		return inventoryItemRepository.save(inventoryItem);
    	} catch(Exception e) {
    		logger.error("Failed to create inventory item",e);
    	}
		return inventoryItem;
    }

    @GetMapping
    @ApiOperation("Get a inventory item")
    public List<InventoryItem> getAllInventoryItems() {
    	try {
    		logger.info("Inventory item got successfully");
    		 return inventoryItemRepository.findAll();
    	} catch(Exception e) {
    		logger.error("Failed to get inventory item",e);
    	}
		return null;
       
    }

    @GetMapping("/{id}")
    @ApiOperation("Get a inventory item by id")
    public InventoryItem getInventoryItemById(@PathVariable String id) {
    	try {
    		logger.info("Inventory item by id got successfully");
    		return inventoryItemRepository.findById(id).orElse(null);
    	} catch(Exception e) {
    		logger.error("Failed to get inventory item by id",e);
    	}
		return null;
        
    }

    @PutMapping("/{id}")
    @ApiOperation("Update inventory item")
    public InventoryItem updateInventoryItem(@PathVariable String id, @RequestBody InventoryItem inventoryItem) {
    	try {
    		logger.info("Inventory item updated successfully");
    		inventoryItem.setId(id);
            return inventoryItemRepository.save(inventoryItem);
    	} catch(Exception e) {
    		logger.error("Failed to update inventory item",e);
    	}
		return inventoryItem;
        
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Update a inventory item")
    public void deleteInventoryItem(@PathVariable String id) {
    	try {
    		logger.info("Inventory item deleted successfully");
    		inventoryItemRepository.deleteById(id);
    	} catch(Exception e) {
    		logger.error("Failed to delete inventory item",e);
    	}
    }

}

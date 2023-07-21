package com.inventory.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

@RestController
@RequestMapping("/api/inventory/item")
public class InventoryController {
	
	@Autowired
    private InventoryItemRepository inventoryItemRepository;

    @PostMapping
    public InventoryItem createInventoryItem(@RequestBody InventoryItem inventoryItem) {
        return inventoryItemRepository.save(inventoryItem);
    }

    @GetMapping
    public List<InventoryItem> getAllInventoryItems() {
        return inventoryItemRepository.findAll();
    }

    @GetMapping("/{id}")
    public InventoryItem getInventoryItemById(@PathVariable String id) {
        return inventoryItemRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public InventoryItem updateInventoryItem(@PathVariable String id, @RequestBody InventoryItem inventoryItem) {
        inventoryItem.setId(id);
        return inventoryItemRepository.save(inventoryItem);
    }

    @DeleteMapping("/{id}")
    public void deleteInventoryItem(@PathVariable String id) {
        inventoryItemRepository.deleteById(id);
    }

}
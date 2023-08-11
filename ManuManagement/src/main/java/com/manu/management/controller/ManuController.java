package com.manu.management.controller;

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

import com.manu.management.model.ManuItem;
import com.manu.management.repository.ManuItemRepository;

@RestController
@CrossOrigin
@RequestMapping("/api/menu/items")
public class ManuController {
	
	@Autowired
	private ManuItemRepository manuItemRepository;
	
	Logger logger = LoggerFactory.getLogger(ManuController.class);
	
	
		@PostMapping
	    public ManuItem createManuItem(@RequestBody ManuItem manuItem) {
			try {
				 logger.info("Menu items created successfully");
				return manuItemRepository.save(manuItem);
			} catch(Exception e) {
				logger.error("Failed to create menu items",e);
			}
			return manuItem;
	    }

	    @GetMapping
	    public List<ManuItem> getAllManuItems() {
	    	try {
	    		logger.info("Menu items got successfully");
				 return manuItemRepository.findAll();
			} catch(Exception e) {
				logger.error("Failed to get menu items");
			}
			return null;
	    }

	    @GetMapping("/{id}")
	    public ManuItem getManuItemById(@PathVariable String id) {
	    	try {
	    		 logger.info("Menu item by id got successfully");
	    		 return manuItemRepository.findById(id).orElse(null);
			} catch(Exception e) {
				logger.error("Failed to get menu item by id");
			}
			return null;
	    }

	    @PutMapping("/{id}")
	    public ManuItem updateManuItem(@PathVariable String id, @RequestBody ManuItem manuItem) {
	    	try {
	    		 logger.info("Menu item updated successfully");
	    		 manuItem.setId(id);
	    		 return manuItemRepository.save(manuItem);
			} catch(Exception e) {
				logger.error("Failed to update menu items");
			}
			return manuItem;
	    }

	    @DeleteMapping("/{id}")
	    public void deleteMenuItem(@PathVariable String id) {
	    	try {
	    		logger.info("Menu item deleted successfully");
	    		 manuItemRepository.deleteById(id);
			} catch(Exception e) {
				logger.error("Failed to detele menu items");
			}
	    }

}

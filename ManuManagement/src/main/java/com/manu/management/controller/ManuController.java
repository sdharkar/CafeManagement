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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin
@RequestMapping("/api/menu/items")
@Api(tags = "Menu API")
public class ManuController {
	
	@Autowired
	private ManuItemRepository manuItemRepository;
	
	Logger logger = LoggerFactory.getLogger(ManuController.class);
	
	
		@PostMapping
		@ApiOperation("Create a menu item")
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
	    @ApiOperation("Get all menu items")
	    public List<ManuItem> getAllManuItems() {
	    	try {
	    		logger.info("Menu items got successfully");
				 return manuItemRepository.findAll();
			} catch(Exception e) {
				logger.error("Failed to get menu items",e);
			}
			return null;
	    }

	    @GetMapping("/{id}")
	    @ApiOperation("Get menu item by id")
	    public ManuItem getManuItemById(@PathVariable String id) {
	    	try {
	    		 logger.info("Menu item by id got successfully");
	    		 return manuItemRepository.findById(id).orElse(null);
			} catch(Exception e) {
				logger.error("Failed to get menu item by id",e);
			}
			return null;
	    }

	    @PutMapping("/{id}")
	    @ApiOperation("Update menu item")
	    public ManuItem updateManuItem(@PathVariable String id, @RequestBody ManuItem manuItem) {
	    	try {
	    		 logger.info("Menu item updated successfully");
	    		 manuItem.setId(id);
	    		 return manuItemRepository.save(manuItem);
			} catch(Exception e) {
				logger.error("Failed to update menu items",e);
			}
			return manuItem;
	    }

	    @DeleteMapping("/{id}")
	    @ApiOperation("Delete menu item")
	    public void deleteMenuItem(@PathVariable String id) {
	    	try {
	    		logger.info("Menu item deleted successfully");
	    		 manuItemRepository.deleteById(id);
			} catch(Exception e) {
				logger.error("Failed to detele menu items",e);
			}
	    }

}

package com.menu.management.controller;

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

import com.menu.management.model.Menu;
import com.menu.management.repository.MenuRepository;

@RestController
@CrossOrigin
@RequestMapping("/cafe/menu/item")
public class MenuController {
	
	@Autowired
	private MenuRepository menuRepository;
	
	
		@PostMapping
	    public Menu createManuItem(@RequestBody Menu menu) {
			try {
				System.out.println("Menu item is created successfully");
				return menuRepository.save(menu);
			} catch(Exception e) {
				System.out.println("error in create menu item");
			}
			return menu;
	    }

	    @GetMapping
	    public List<Menu> getAllMenuItems() {
	    	try {
	    		System.out.println("Menu items got successfully");
				 return menuRepository.findAll();
			} catch(Exception e) {
				System.out.println("Failed to get menu items");
			}
			return null;
	    }

	    @GetMapping("/{id}")
	    public Menu getMenuItemById(@PathVariable String id) {
	    	try {
	    		System.out.println("Menu item by id got successfully");
	    		 return menuRepository.findById(id).orElse(null);
			} catch(Exception e) {
				System.out.println("Failed to get menu item by id");
			}
			return null;
	    }

	    @PutMapping("/{id}")
	    public Menu updateManuItem(@PathVariable String id, @RequestBody Menu menu) {
	    	try {
	    		System.out.println("Menu item updated successfully");
	    		 menu.setId(id);
	    		 return menuRepository.save(menu);
			} catch(Exception e) {
				System.out.println("Failed to update menu items");
			}
			return menu;
	    }

	    @DeleteMapping("/{id}")
	    public void deleteMenuItem(@PathVariable String id) {
	    	try {
	    		System.out.println("Menu item deleted successfully");
	    		 menuRepository.deleteById(id);
			} catch(Exception e) {
				System.out.println("Failed to detele menu items");
			}
	    }

}

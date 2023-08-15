package com.menu.management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.menu.management.model.Menu;
import com.menu.management.repository.MenuRepository;

@Service
public class MenuService {
	
	@Autowired
	private MenuRepository menuRepository;
	
	
	public Menu createMenuItem(Menu menu) {
        return menuRepository.save(menu);
    }

    public List<Menu> getAllMenuItems() {
        return menuRepository.findAll();
    }

    public Optional<Menu> getMenuItemById(String id) {
        return menuRepository.findById(id);
    }

    public Menu updateMenuItem(String id, Menu menu) {
        menu.setId(id);
        return menuRepository.save(menu);
    }

    public void deleteMenuItem(String id) {
        menuRepository.deleteById(id);
    }



}

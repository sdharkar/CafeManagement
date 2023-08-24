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

    // Create new menu item
    public Menu createMenuItem(Menu menu) {
        return menuRepository.save(menu);
    }

    // get all menu items
    public List<Menu> getAllMenuItems() {
        return menuRepository.findAll();
    }

    // Search by name
    public Optional<Menu> getMenuItemByName(String name) {
        return menuRepository.findByName(name);
    }

    // get menu item by id
    public Optional<Menu> getMenuItemById(String id) {
        return menuRepository.findById(id);
    }

    // update menu item
    public Menu updateMenuItem(String id, Menu menu) {
        menu.setId(id);
        return menuRepository.save(menu);
    }

    // delete menu item
    public void deleteMenuItem(String id) {
        menuRepository.deleteById(id);
    }

}

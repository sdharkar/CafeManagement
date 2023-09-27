package com.cafe.management.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cafe.management.model.Menu;

@Service
public interface MenuService {
	
	 public List<Menu> getAllMenu();

	    public List<Menu> getAllMenuByUsername(String username);

	    public Menu getMenuByMenuName(String menuName);

	    public String setMenu(Menu menu);

	    public String updateMenu(Menu menu);

	    public String deleteMenu(String menuName);

}

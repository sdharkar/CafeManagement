package com.cafe.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe.management.Repository.MenuRepo;
import com.cafe.management.model.Menu;

@Service
public class MenuServiceImpl implements MenuService{
	
	@Autowired
	private MenuRepo menuRepo;

	@Override
	public List<Menu> getAllMenu() {
		return this.menuRepo.findAll();
	}

	@Override
	public List<Menu> getAllMenuByUsername(String username) {
		return this.menuRepo.findByUsername(username);
	}

	@Override
	public Menu getMenuByMenuName(String menuName) {
		return this.menuRepo.findByMenuName(menuName);
	}

	@Override
	public String setMenu(Menu menu) {
		this.menuRepo.save(menu);
		 return "Product Details Added Successfully!";
	}

	@Override
	public String updateMenu(Menu menu) {
		this.menuRepo.save(menu);
		return "Menu details are updated";
	}

	@Override
	public String deleteMenu(String menuName) {
		this.menuRepo.deleteById(menuName);
		return "Menu Details Deleted Successfully!";
	}

}

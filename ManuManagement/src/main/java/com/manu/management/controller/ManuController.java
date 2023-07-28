package com.manu.management.controller;

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

import com.manu.management.model.ManuItem;
import com.manu.management.repository.ManuItemRepository;

@RestController
@CrossOrigin
@RequestMapping("/api/menu/items")
public class ManuController {
	
	@Autowired
	private ManuItemRepository manuItemRepository;
	
	
		@PostMapping
	    public ManuItem createManuItem(@RequestBody ManuItem manuItem) {
			return manuItemRepository.save(manuItem);
	    }

	    @GetMapping
	    public List<ManuItem> getAllManuItems() {
	        return manuItemRepository.findAll();
	    }

	    @GetMapping("/{id}")
	    public ManuItem getManuItemById(@PathVariable String id) {
	        return manuItemRepository.findById(id).orElse(null);
	    }

	    @PutMapping("/{id}")
	    public ManuItem updateManuItem(@PathVariable String id, @RequestBody ManuItem manuItem) {
	        manuItem.setId(id);
	        return manuItemRepository.save(manuItem);
	    }

	    @DeleteMapping("/{id}")
	    public void deleteMenuItem(@PathVariable String id) {
	        manuItemRepository.deleteById(id);
	    }

}

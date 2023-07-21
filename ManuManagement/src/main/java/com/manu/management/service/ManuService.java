package com.manu.management.service;

import java.awt.MenuItem;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manu.management.model.ManuItem;
import com.manu.management.repository.ManuItemRepository;

@Service
public class ManuService {
	
	@Autowired
	private ManuItemRepository manuItemRepository;
	
	
	public ManuItem createMenuItem(ManuItem manuItem) {
        return manuItemRepository.save(manuItem);
    }

    public List<ManuItem> getAllManuItems() {
        return manuItemRepository.findAll();
    }

    public Optional<ManuItem> getManuItemById(String id) {
        return manuItemRepository.findById(id);
    }

    public ManuItem updateManuItem(String id, ManuItem manuItem) {
        manuItem.setId(id);
        return manuItemRepository.save(manuItem);
    }

    public void deleteMenuItem(String id) {
        manuItemRepository.deleteById(id);
    }


}

package com.batch12.meru.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.batch12.meru.entities.Inventory;
import com.batch12.meru.exceptions.InventoryNotFound;
import com.batch12.meru.repositories.InventoryRepository;

//This Implementation will use CRUD Repository Layer, Actual Database

@Service
@Primary
public class InventoryServiceImpl implements InventoryService {
	
	@Autowired
	InventoryRepository inventoryRepository;
		
	@Override
	public Inventory getInventory(int id) {
		
		Optional<Inventory> inventoryOpt = inventoryRepository.findById(id);
		if (!inventoryOpt.isPresent()) {
			throw new InventoryNotFound("Id --" +id);
		}
		
		Inventory inventory = inventoryOpt.get();
		return inventory;
	
	}

	@Override
	public List<Inventory> getInventorys() {
	
		List<Inventory> inventorys = (List<Inventory>) inventoryRepository.findAll();
		return inventorys;
	
	}

	@Override
	public Inventory createInventory(Inventory inventory) {
		
		Inventory inventorySaved = inventoryRepository.save(inventory);
		return inventorySaved;
		
	}

	@Override
	public Inventory updateInventory(int id, Inventory inventory) {
		
		Optional<Inventory> inventoryOpt = inventoryRepository.findById(id);
		if (!inventoryOpt.isPresent()) {
			throw new InventoryNotFound("Id --" +id);
		}
	
		Inventory inventoryUpdated = inventoryOpt.get();
		
		inventoryUpdated.setQuantity(inventory.getQuantity());
		inventoryUpdated.setSuuplierName(inventory.getSuuplierName());
		
		inventoryRepository.save(inventoryUpdated);
		
		return inventoryUpdated;	

	}

	@Override
	public Inventory deleteInventory(int id) {
		
		Optional<Inventory> inventoryOpt = inventoryRepository.findById(id);
		if (!inventoryOpt.isPresent()) {
			throw new InventoryNotFound("Id --" +id);
		}
		
		Inventory inventoryDeleted = inventoryOpt.get();
		
		inventoryRepository.delete(inventoryDeleted);
		
		return inventoryDeleted;
		
	}
	
}

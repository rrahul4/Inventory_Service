package com.batch12.meru.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.batch12.meru.entities.Inventory;
import com.batch12.meru.exceptions.InventoryNotFound;
import com.batch12.meru.service.InventoryService;

@RestController
public class InventoryController {
	
	@Autowired
	InventoryService inventoryService;
	
	@GetMapping("/inventorys")
	public List<Inventory> getInventorys() {
		return inventoryService.getInventorys();
		
	}

	@GetMapping("/inventorys/{id}")
	public Inventory getCustomer(@PathVariable int id) {
		Inventory inventory = inventoryService.getInventory(id);
		if (inventory.getProductId()==null) {
			throw new InventoryNotFound("Id --" +id);
		}
		
		return inventory;	
	}
	
	@PostMapping("/inventorys")
	public ResponseEntity<Inventory> createInventory(@RequestBody Inventory inventory) {
		Inventory savedInventory = inventoryService.createInventory(inventory);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedInventory.getProductId())
				.toUri();
		
		return ResponseEntity.created(location).build();
	}

	@PutMapping("/inventorys/{id}")
	public void updateInventory(@PathVariable int id, @RequestBody Inventory inventory) {
		
		Inventory updatedInventory = inventoryService.updateInventory(id, inventory);
		
		if (updatedInventory.getProductId()==null) {
			throw new InventoryNotFound("Id --" +id);
		}
	}
	
	@DeleteMapping("/inventorys/{id}")
	public void deleteInventory(@PathVariable int id) {
		
		Inventory deletedInventory = inventoryService.deleteInventory(id);
		if (deletedInventory.getProductId()==null) {
			throw new InventoryNotFound("Id --" +id);
		}	
	}
	
}

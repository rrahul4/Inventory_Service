package com.batch12.meru.repositories;

import org.springframework.data.repository.CrudRepository;
import com.batch12.meru.entities.Inventory;

public interface InventoryRepository extends CrudRepository<Inventory, Integer> {
	
	
}

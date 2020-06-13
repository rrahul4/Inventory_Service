package com.batch12.meru;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.batch12.meru.entities.Inventory;
import com.batch12.meru.service.InventoryService;

@SpringBootApplication
public class InventoryServiceApplication  implements CommandLineRunner {
	
	@Autowired
	private InventoryService inventoryService;
	
	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(" -- 1. Begin - Command Line Runner -- ");
		
		Inventory inventory = (new Inventory(1, 100, "ABC"));
		
		inventoryService.createInventory(inventory);
		
		System.out.println(" -- 1. End - Command Line Runner -- ");
	}


}

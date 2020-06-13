package com.batch12.meru.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.batch12.meru.entities.Inventory;
import com.batch12.meru.repositories.InventoryRepository;
import com.batch12.meru.service.InventoryService;

//This Test will use Embedded DataBase with @DataJpaTest

@ExtendWith(SpringExtension.class)
@TestMethodOrder(OrderAnnotation.class)
@DataJpaTest
class InventoryRepository2Test {

	@Autowired
	InventoryRepository inventoryRepository;
	
// This Bean is created to support CommandLineRunner from Main Spring Boot Application by Autowiring InventoryService.
// @WebMvcTest will not create all Beans from application unlike @SpringBootTest does it.
	@MockBean
	private InventoryService inventoryService;

	@Test
	@Order(1)
	public void createInventory() {
		
		Inventory inventory1 = new Inventory();
		inventory1.setProductId(1);
		inventory1.setQuantity(100);
		inventory1.setSuuplierName("ABC");

		Inventory inventory2 = new Inventory();
		inventory2.setProductId(2);
		inventory2.setQuantity(200);
		inventory2.setSuuplierName("DEF");
		
		Inventory inventory3 = new Inventory();
		inventory3.setProductId(3);
		inventory3.setQuantity(300);
		inventory3.setSuuplierName("GHI");
		
		Inventory inventory4 = new Inventory();
		inventory4.setProductId(4);
		inventory4.setQuantity(400);
		inventory4.setSuuplierName("PQR");

		inventoryRepository.save(inventory1);
		inventoryRepository.save(inventory2);
		inventoryRepository.save(inventory3);
		inventoryRepository.save(inventory4);
		
	}

	@Test
	@Order(2)
	@Transactional
	public void getInventorys() {
		createInventory();
		
		Iterable<Inventory> inventorys = inventoryRepository.findAll();

		for (Inventory inventory : inventorys) {
			System.out.println(inventory);
			
		}
	}
	
	@Test
	@Order(3)
	@Transactional
	public void getInventory() {
		createInventory();
		
		Optional<Inventory> inventoryOpt = inventoryRepository.findById(9);
		Inventory inventory = inventoryOpt.get();
		System.out.println(inventory);
		
	}
	
}
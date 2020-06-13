package com.batch12.meru.service;

import java.util.List;

import com.batch12.meru.entities.Inventory;

public interface InventoryService {
	
	public Inventory getInventory(int id);
	public List<Inventory> getInventorys();
	public Inventory createInventory(Inventory inventory);
	public Inventory updateInventory(int id, Inventory Inventory);
	public Inventory deleteInventory(int id);

}

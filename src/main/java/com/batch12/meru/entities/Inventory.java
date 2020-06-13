package com.batch12.meru.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Inventory {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer productId;
	private Integer quantity;
	private String supplierName;
	

	public Inventory() {
		super();
	}


	public Inventory(Integer productId, Integer quantity, String supplierName) {
		super();
		this.productId = productId;
		this.quantity = quantity;
		this.supplierName = supplierName;
	}


	public Integer getProductId() {
		return productId;
	}


	public void setProductId(Integer productId) {
		this.productId = productId;
	}


	public Integer getQuantity() {
		return quantity;
	}


	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}


	public String getSuuplierName() {
		return supplierName;
	}


	public void setSuuplierName(String supplierName) {
		this.supplierName = supplierName;
	}


	@Override
	public String toString() {
		return "Inventory [productId=" + productId + ", quantity=" + quantity + ", supplierName=" + supplierName + "]";
	}

		
	
	
}

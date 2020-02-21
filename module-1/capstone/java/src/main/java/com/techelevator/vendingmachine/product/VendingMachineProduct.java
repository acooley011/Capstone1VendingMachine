package com.techelevator.vendingmachine.product;

public interface VendingMachineProduct {
	int quantity = 5;
	
	String getLocation();
	String getName();
	double getPrice();
	String getType();
	int getQuantity();
	
}

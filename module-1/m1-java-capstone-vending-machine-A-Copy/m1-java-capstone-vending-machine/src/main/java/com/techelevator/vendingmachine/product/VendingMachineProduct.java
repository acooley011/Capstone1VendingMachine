package com.techelevator.vendingmachine.product;

public interface VendingMachineProduct {
	
	String getLocation();
	String getName();
	double getPrice();
	String getType();
	int getQuantity();
	void setQuantity(int quantity);
	String getMessage();
	
}

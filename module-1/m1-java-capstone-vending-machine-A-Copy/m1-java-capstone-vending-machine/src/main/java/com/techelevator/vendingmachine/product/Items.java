package com.techelevator.vendingmachine.product;

public class Items {

	//C:\Users\Student\workspace\java-module-1-capstone-team-6\module-1\capstone\java\vendingmachine.csv";

	//private members
	private String name;
	private double price;
	private String slot;
	private String type;

	//CTOR
	public Items(String name, double price, String slot, String type) {
		this.name = name;
		this.price = price;
		this.slot = slot;
		this.type = type;
	}

	//getters
	//this should get all properties from the file using the method from InventoryScanner
	public String getName() {

		return this.name;
	}
	public double getPrice() {

		return this.price;
	}
	public String getSlot() {

		return this.slot;
	}
	public String getType() {

		return this.type;
	}


}

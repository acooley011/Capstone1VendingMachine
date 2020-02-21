package com.techelevator.vendingmachine.product;

public class Chip implements VendingMachineProduct {
	
	private String location;
	private String name;
	private double price;
	private String type;
	
	public String getMessage() {
		return "Crunch Crunch, Yum!";
	}

	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public int getQuantity() {
		// TODO Auto-generated method stub
		return 5;
	}

}

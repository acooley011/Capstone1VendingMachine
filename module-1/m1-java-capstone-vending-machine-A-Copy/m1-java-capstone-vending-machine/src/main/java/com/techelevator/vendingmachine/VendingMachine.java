package com.techelevator.vendingmachine;

import java.util.Map;
import com.techelevator.vendingmachine.product.VendingMachineProduct;

public class VendingMachine {
	
//	main class for vending that holds vm products, accepts money, and dispenses products
	//attributes
	
	private Map<String, VendingMachineProduct> vendoProducts;
	
	public Map<String, VendingMachineProduct> getVendoProducts() {
		return vendoProducts;
	}

	public void setVendoProducts(Map<String, VendingMachineProduct> vendoProducts) {
		this.vendoProducts = vendoProducts;
	}

	public void feedMoney(double money) {
		
	}
	
	public VendingMachineProduct dispense() {
		
		VendingMachineProduct vmp = null;
		
		return vmp;
	}
	


	
}

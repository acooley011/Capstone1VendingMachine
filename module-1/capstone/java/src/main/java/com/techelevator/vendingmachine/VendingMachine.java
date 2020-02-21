package com.techelevator.vendingmachine;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.techelevator.vendingmachine.product.Beverage;
import com.techelevator.vendingmachine.product.Candy;
import com.techelevator.vendingmachine.product.Chip;
import com.techelevator.vendingmachine.product.Gum;
import com.techelevator.vendingmachine.product.Items;
import com.techelevator.vendingmachine.product.VendingMachineProduct;



public class VendingMachine {
	
	
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

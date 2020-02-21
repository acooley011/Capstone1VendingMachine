package com.techelevator.vendingmachine;

import java.util.Iterator;

import com.techelevator.vendingmachine.product.VendingMachineProduct;

public class PrintListForSelectItem {

	public PrintListForSelectItem() {
		// TODO Auto-generated constructor stub
	}
	
	public void printItems() {
		//sf: create and instantiate VendingMachine (vm) Object
		String inventoryList = "C:\\Users\\Student\\workspace\\java-module-1-capstone-team-6\\module-1\\capstone\\java\\src\\main\\resources\\vendo_stocks.txt";
	
		//sf: invoke VML to get a new VM instance 
		VendingMachineLoader vml = new VendingMachineLoader();
		
		//and load it with the inventory list
		VendingMachine vm = vml.reStock(inventoryList);
				
		Iterator<VendingMachineProduct> iter =  vm.getVendoProducts().values().iterator();
		
		while(iter.hasNext() ) {
			VendingMachineProduct vmp = (VendingMachineProduct) iter.next();
				System.out.println("Item: " + vmp.getName() + " | Item Code " + vmp.getLocation());
		}
	}

}

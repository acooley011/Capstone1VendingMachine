package com.techelevator.vendingmachine;

import java.util.Iterator;
import java.util.Map;

import com.techelevator.vendingmachine.product.VendingMachineProduct;


//sub menu called by the vending machine cli, through the main menu to display selected items

public class PrintListForSelectItem {
	
	private Map<String, VendingMachineProduct> vendoProducts;

	public PrintListForSelectItem(Map<String, VendingMachineProduct> vendoProducts) {
		this.vendoProducts = vendoProducts;
	}
	
	public void printItems() {
				
		Iterator<VendingMachineProduct> iter = vendoProducts.values().iterator();
		
		while( iter.hasNext() ) {
			VendingMachineProduct vmp = (VendingMachineProduct) iter.next();
		
				if(vmp.getName().equals("Little League Chew")) {
					System.out.println("Item: " + vmp.getName() + "| Item Code " + vmp.getLocation() + " \t| Item Price " + vmp.getPrice());
				} else if(vmp.getName().equals("U-Chews") || vmp.getName().equals("Cola") || vmp.getName().equals("Moonpie") || vmp.getName().equals("Heavy")) {
					System.out.println("Item: " + vmp.getName() + " \t\t| Item Code " + vmp.getLocation() + " \t| Item Price " + vmp.getPrice());
				} else if (vmp.getName().equals("Dr. Salt") || vmp.getName().equals("Chiclets") || vmp.getName().equals("Cowtales") || vmp.getName().equals("Stackers") || vmp.getName().equals("Crunchie")) {
					System.out.println("Item: " + vmp.getName() + " \t\t| Item Code " + vmp.getLocation() + " \t| Item Price " + vmp.getPrice());
				} else {
					System.out.println("Item: " + vmp.getName() + " \t| Item Code " + vmp.getLocation() + " \t| Item Price " + vmp.getPrice());
				}
		}

	}

}

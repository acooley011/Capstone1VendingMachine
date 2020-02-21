package com.techelevator.vendingmachine;

import java.util.Iterator;
import java.util.Scanner;

import com.techelevator.vendingmachine.product.VendingMachineProduct;
import com.techelevator.vendingmachine.view.Menu;

public class SelectItem {

	public SelectItem() {
		
	}

	public void run() {
		
		//sf: create and instantiate VendingMachine (vm) Object
		String inventoryList = "C:\\Users\\Student\\workspace\\java-module-1-capstone-team-6\\module-1\\capstone\\java\\src\\main\\resources\\vendo_stocks.txt";
		
		//sf: invoke VML to get a new VM instance 
		VendingMachineLoader vml = new VendingMachineLoader();
				
		//and load it with the inventory list
		VendingMachine vm = vml.reStock(inventoryList);
		
		String itemCode = "";
		
		PrintListForSelectItem print = new PrintListForSelectItem();
		print.printItems();
		
		while (true) {	
			Iterator<VendingMachineProduct> iter =  vm.getVendoProducts().values().iterator();
				VendingMachineProduct vmp = (VendingMachineProduct) iter.next();
					System.out.print("Please enter item code: ");
					Scanner userInput = new Scanner(System.in);
					try {
						itemCode = userInput.next();
						if(itemCode.equals(vmp.getLocation()) && vmp.getQuantity() > 0) {
							PurchaseMenu currentMoney = new PurchaseMenu();
							System.out.println("Purchased " + vmp.getName() + "for $" + vmp.getPrice() + ". remaining money is " + (currentMoney.getTotalMoney() - vmp.getPrice()));
							System.out.println(vmp.getMessage());
						} else {
							System.out.println(vmp.getName() + " is SOLD OUT");

						}
						
					} catch (Exception e) {
						System.out.println(itemCode + " does not exist!");

					}				
			
		}
	}
	
	
}

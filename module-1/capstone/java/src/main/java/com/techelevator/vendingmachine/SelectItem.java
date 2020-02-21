package com.techelevator.vendingmachine;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import com.techelevator.vendingmachine.product.VendingMachineProduct;
import com.techelevator.vendingmachine.view.Menu;

public class SelectItem {

	public SelectItem() {
		
	}
	
	static ArrayList<String> codeList = new ArrayList<String>();

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
			while(iter.hasNext() ) {
				VendingMachineProduct vmp = (VendingMachineProduct) iter.next();

				System.out.print("Please enter item code: ");
				Scanner userInput = new Scanner(System.in);
			
				try {
					itemCode = userInput.next();
					codeList.add(vmp.getLocation());
				
				
			} catch (Exception e) {
						System.out.println(itemCode + " does not exist!");
			}
			}
			for (String i : codeList) {
				VendingMachineProduct vmp = (VendingMachineProduct) iter.next();
				
				if(i.equalsIgnoreCase(itemCode) && vmp.getQuantity() > 0) {
					PurchaseMenu currentMoney = new PurchaseMenu();
					System.out.println("Purchased " + vmp.getName() + "for $" + vmp.getPrice() + ". remaining money is " + (currentMoney.getTotalMoney() - vmp.getPrice()));
					double moneyAfterPurchase = 0;
					moneyAfterPurchase -= vmp.getPrice();
					System.out.println(vmp.getMessage());
				}
			}
		}
	}
}

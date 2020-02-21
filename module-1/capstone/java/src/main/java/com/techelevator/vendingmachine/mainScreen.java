package com.techelevator.vendingmachine;

import java.util.*;

import com.techelevator.vendingmachine.product.Items;

public class mainScreen{

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner userInput =  new Scanner(System.in);
		
		InventoryScanner is = new InventoryScanner();
		Map<String, Items> productMap = is.scan();
		//this is a list from inventory scanner of our items. we need to get the info out of this list to use it.
		
		System.out.println("(1) Display Vending Machine Items");
		System.out.println("(2) Purchase");
		System.out.println("(3) Exit");
		String choice = userInput.nextLine();
		
		
		if(choice.equals("1")) {
			//loop through list created by the input file.
			System.out.print(productMap.get(""));
		} else if (choice.equals("2")) {
			//go to a purchase method, that shows a new menu for add money, select and vend, and finish transaction.
		} 
	}
	
	//working theory is to get this info from inventory scanner.
}

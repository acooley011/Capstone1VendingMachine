package com.techelevator;

import java.io.File;
import java.util.Scanner;

public class InventoryScanner {
	
	public static void main(String[] args) throws Exception{

//	public InventoryScanner() {
//		// TODO Auto-generated constructor stub
//	}
	
		//make a public method that gets individual name, price, slot, type.
		File inventoryFile = new File("vendingmachine.csv");
	
		Scanner inventoryScanner = new Scanner(inventoryFile);
		
		while(inventoryScanner.hasNextLine()) {
			String[] productInfo = inventoryScanner.nextLine().split("[|]");
			String slot = productInfo[0];
			String name = productInfo[1];
			String price = productInfo[2];
			String type = productInfo[3];
			
			System.out.println(slot +" "+ name+" " + price+" " + type);
		}				
	}
}

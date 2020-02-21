package com.techelevator.vendingmachine;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.techelevator.vendingmachine.product.Items;

public class InventoryScanner {
	
	//CTOR
	public InventoryScanner() {
	}	
	
	//scan method that looks through our file
	//I dont know why the other argument of the map is our own class Items. So I think we should change it to an array
	public Map<String, Items> scan() throws Exception{
		
		Map<String, Items> info = new HashMap<>();
		String slot = "";
		String name = "";
		double price = 0.0;
		String type = "";

		File inventoryFile = new File("vendingmachine.csv");
	
		Scanner inventoryScanner = new Scanner(inventoryFile);
		
		while(inventoryScanner.hasNextLine()) {
			String[] productInfo = inventoryScanner.nextLine().split("[|]");
			
			slot = productInfo[0];
			name = productInfo[1];
			price = Double.valueOf(productInfo[2]);
			type = productInfo[3];
			
			Items i = new Items(name, price, slot, type);

			info.put(slot, i);
			
			//System.out.println(slot +" "+ name+" " + price+" " + type);
		}
		
		//sf:close the scanner to avoid leak
		inventoryScanner.close();
		
		return info;
//		
	}
}

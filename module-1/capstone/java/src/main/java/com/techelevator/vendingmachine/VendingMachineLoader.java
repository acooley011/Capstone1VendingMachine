package com.techelevator.vendingmachine;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.techelevator.vendingmachine.product.Beverage;
import com.techelevator.vendingmachine.product.Candy;
import com.techelevator.vendingmachine.product.Chip;
import com.techelevator.vendingmachine.product.Gum;
import com.techelevator.vendingmachine.product.VendingMachineProduct;

public class VendingMachineLoader {

	public VendingMachine reStock(String inventoryList) {
		VendingMachine vendo = new VendingMachine();
		
		Map<String, VendingMachineProduct> vendoProducts = processInventory(inventoryList);
		vendo.setVendoProducts(vendoProducts);
		
		return vendo;
	}

	private Map<String, VendingMachineProduct> processInventory(String inventoryList) {
		
		Map<String, VendingMachineProduct> vendoProducts = new HashMap<>();

		try {
			File inventoryFile = new File(inventoryList);
			Scanner inventoryScanner;
			
			inventoryScanner = new Scanner(inventoryFile);
			while(inventoryScanner.hasNextLine()) {
				String[] productInfo = inventoryScanner.nextLine().split("[|]");
				
				if(productInfo[3].equalsIgnoreCase("Drink")) {
					
					Beverage beverage = new Beverage();
					beverage.setLocation(productInfo[0]);
					beverage.setName(productInfo[1]);
					beverage.setPrice(Double.valueOf(productInfo[2]));
					beverage.setType(productInfo[3]);
					vendoProducts.put(productInfo[0], beverage);
					
				} else if(productInfo[3].equalsIgnoreCase("Candy")) {
					
					Candy candy = new Candy();
					candy.setLocation(productInfo[0]);
					candy.setName(productInfo[1]);
					candy.setPrice(Double.valueOf(productInfo[2]));
					candy.setType(productInfo[3]);
					vendoProducts.put(productInfo[0], candy);
					
				} else if(productInfo[3].equalsIgnoreCase("Chip")) {
					
					Chip chip = new Chip();
					chip.setLocation(productInfo[0]);
					chip.setName(productInfo[1]);
					chip.setPrice(Double.valueOf(productInfo[2]));
					chip.setType(productInfo[3]);
					vendoProducts.put(productInfo[0], chip);
					
				} else if(productInfo[3].equalsIgnoreCase("Gum")) {
					
					Gum gum = new Gum();
					gum.setLocation(productInfo[0]);
					gum.setName(productInfo[1]);
					gum.setPrice(Double.valueOf(productInfo[2]));
					gum.setType(productInfo[3]);
					vendoProducts.put(productInfo[0], gum);
				}
			}
			
			System.out.println("Vendo product size: " + vendoProducts.size());

			//sf:close the scanner to avoid leak
			inventoryScanner.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return vendoProducts;
		
		
	}

	
}

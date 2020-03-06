package com.techelevator.vendingmachine;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Map;
import java.util.Scanner;

import com.techelevator.vendingmachine.product.VendingMachineProduct;

public class SelectItem {

	private Map<String, VendingMachineProduct> vendoProducts;
	private Bank currentMoney;
	private double totalMoney;
	private Scanner userInput;

	//sf: again pass the same instance of VM
	public SelectItem(Map<String, VendingMachineProduct> vendoProducts, Bank currentMoney) {
		this.vendoProducts = vendoProducts;
		this.currentMoney = currentMoney;
	}

	public SelectItem(Map<String, VendingMachineProduct> vendoProducts, double totalMoney) {
		this.vendoProducts = vendoProducts;
		this.totalMoney = totalMoney;
	}
    private static DecimalFormat df2 = new DecimalFormat("#.##");

	public double run() {
		while (true) {
			String itemCode = "";
			
			PrintListForSelectItem print = new PrintListForSelectItem(vendoProducts);
			print.printItems();
			
			//logger
			Logger log = new Logger();
			
			System.out.print("Please enter item code: ");
			userInput = new Scanner(System.in);
			itemCode = userInput.next();
			
			System.out.println("----------------");
			System.out.println("Buying item with code: [" + itemCode + "]");
			
			if(vendoProducts.containsKey(itemCode)) {
				VendingMachineProduct vmp = vendoProducts.get(itemCode);
				
				if(itemCode.equals(vmp.getLocation()) && vmp.getQuantity() != 0) {
					//PurchaseMenu currentMoney = new PurchaseMenu();
					df2.setRoundingMode(RoundingMode.UP);

					double remainingMoney = totalMoney - vmp.getPrice();					
					
					if(Double.valueOf(df2.format(remainingMoney)) < 0) {
						System.out.println("----------------");
						System.out.println("Sorry, not enough money!!!");
						System.out.println("----------------");
						//return to pruchase menu
						return totalMoney;

					} else {
						System.out.println("----------------");
						System.out.println("Purchased " + vmp.getName() + " for $" + vmp.getPrice() + ". remaining money is $" + remainingMoney);
						System.out.println("Quantity before purchase for " + vmp.getName() + " is: " + vmp.getQuantity());
						int remainingQuantity = vmp.getQuantity() - 1;
						vmp.setQuantity(remainingQuantity);
						System.out.println(vmp.getMessage());
						System.out.println("Remaining quantity for " + vmp.getName() + " is: " + vmp.getQuantity());
						System.out.println("----------------");
						
						String logThis = vmp.getName() + " " + vmp.getLocation() + " $" + String.valueOf(totalMoney) + " $" + remainingMoney;
						log.log(logThis);
						
						//return to pruchase menu
						return remainingMoney;
					}
					
				} else {
					System.out.println(vmp.getName() + " is SOLD OUT");
					//return to pruchase menu
					return totalMoney;
					
				}
			} else {
				System.out.println(itemCode + " does not exist!");
				return totalMoney;
			}
			
		}

	}
	
}

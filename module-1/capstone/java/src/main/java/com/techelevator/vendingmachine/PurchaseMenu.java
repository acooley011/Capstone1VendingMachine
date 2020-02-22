package com.techelevator.vendingmachine;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.logging.Logger;

import com.techelevator.vendingmachine.product.VendingMachineProduct;
import com.techelevator.vendingmachine.view.Menu;


public class PurchaseMenu {
	public PurchaseMenu() {
		
	}
	
	private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
	private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
	//sf:Add Exit option
	private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";
	private static final String[] PURCHASE_MENU_OPTIONS = { PURCHASE_MENU_OPTION_FEED_MONEY, PURCHASE_MENU_OPTION_SELECT_PRODUCT, PURCHASE_MENU_OPTION_FINISH_TRANSACTION};
	
	String dollar = "";
	int amount = 0;
	int totalMoney = 0;
	int quarters = 0;
	int dimes = 0;
	int nickels = 0;
	
	private Menu menu;

	public PurchaseMenu(Menu menu) {
		this.menu = menu;
	}

	public void run() {
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
			
			if (choice.equals(PURCHASE_MENU_OPTION_FEED_MONEY)) {
				
				Bank currentMoney = new Bank(dollar, amount);
				totalMoney = currentMoney.moneyFed();
				
				//creates a new file at the path. we will have to make this gettable for other classes if we want them to update it
				File log = new File("/m1-java-capstone-vending-machine/src/main/java/com/techelevator/vendingmachine/");
				PrintWriter logger = null;
				try {
					logger = new PrintWriter(log);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				try {
					log.createNewFile();
					logger = new PrintWriter(log);

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				// this prints the updated feed money to the log file
				logger.println(totalMoney);
				
				System.out.println("Current Money Provided: " + totalMoney);
				
			} else if (choice.equals(PURCHASE_MENU_OPTION_SELECT_PRODUCT)){
				SelectItem select = new SelectItem();
				select.run();
				
			} else if (choice.equals(PURCHASE_MENU_OPTION_FINISH_TRANSACTION)) {
			//	totalMoney = moneyAfterPurchase;
				totalMoney *= 100;
				if(totalMoney > 25) {
					totalMoney -=  25;
					quarters ++;
				} else if(totalMoney > 10) {
					totalMoney -=  10;
					dimes ++;
				} else if(totalMoney > 5) {
					totalMoney -=  5;
					nickels ++;
				}
				System.out.println("Change: " + quarters + " quarters, " + dimes + " dimes, " + nickels + " nickels.");
				
				int totalChange = quarters * 25 + dimes * 10 + nickels * 5;
				
				//sigh. i cant figure out how to get this. i think it needs to be instantiated out of the run block, but i also cant get THAT it to work.
				//should print the updated money
				logger.println(totalChange);
				
				totalMoney = 0;
				//then it needs to return to VendingMachine CLI menu

				
			}
		}
	}
	public int getTotalMoney() {
		return totalMoney;
	}
}

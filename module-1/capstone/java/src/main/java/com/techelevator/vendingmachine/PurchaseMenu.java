package com.techelevator.vendingmachine;

import java.util.Iterator;

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
				totalMoney = 0;
				//then it needs to return to VendingMachine CLI menu
				
			}
		}
	}
	public int getTotalMoney() {
		return totalMoney;
	}
}

package com.techelevator.vendingmachine;

import java.util.Iterator;

import com.techelevator.vendingmachine.product.VendingMachineProduct;
import com.techelevator.vendingmachine.view.Menu;

public class PurchaseMenu {
	
	private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
	private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
	//sf:Add Exit option
	private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";
	private static final String[] PURCHASE_MENU_OPTIONS = { PURCHASE_MENU_OPTION_FEED_MONEY, PURCHASE_MENU_OPTION_SELECT_PRODUCT, PURCHASE_MENU_OPTION_FINISH_TRANSACTION};
	
	String dollar = "";
	int amount = 0;
	
	private Menu menu;

	public PurchaseMenu(Menu menu) {
		this.menu = menu;
	}

	public void run() {
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
			
			if (choice.equals(PURCHASE_MENU_OPTION_FEED_MONEY)) {
				
				Bank currentMoney = new Bank(dollar, amount);
				int totalMoney = currentMoney.moneyFed();
				
				System.out.println("Current Money Provided: " + totalMoney);
				
			} else {
				
			}
		}
	}
}

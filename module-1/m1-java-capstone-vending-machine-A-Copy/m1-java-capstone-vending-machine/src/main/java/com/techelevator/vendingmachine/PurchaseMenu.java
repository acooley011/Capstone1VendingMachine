package com.techelevator.vendingmachine;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Map;

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
	double totalMoney = 0.0;
	int quarters = 0;
	int dimes = 0;
	int nickels = 0;
	
	private Menu menu;
	private Map<String, VendingMachineProduct> vendoProducts;
	private Bank bank;
	
	//sf: added the same VM instance
	public PurchaseMenu(Menu menu, Map<String, VendingMachineProduct> vendoProducts) {
		this.menu = menu;
		this.vendoProducts = vendoProducts;
	}
	
	//logger
	Logger log = new Logger();
	
    private static DecimalFormat df2 = new DecimalFormat("#");

	public void run() {
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
			
			if (choice.equals(PURCHASE_MENU_OPTION_FEED_MONEY)) {
				
				Bank currentMoney = new Bank(dollar, amount);
				double moneyAfterFeed = currentMoney.moneyFed();
				totalMoney += moneyAfterFeed;
				
				System.out.println("Current Money Provided: $" + totalMoney);
				
				double moneyPre = totalMoney - moneyAfterFeed;
			
				String logThis = "FEED MONEY: $" + String.valueOf(moneyPre) + " $" + String.valueOf(totalMoney);
				log.log(logThis);
				
			} else if (choice.equals(PURCHASE_MENU_OPTION_SELECT_PRODUCT)){
				SelectItem select = new SelectItem(vendoProducts, totalMoney);
				totalMoney = select.run();
				
			} else if (choice.equals(PURCHASE_MENU_OPTION_FINISH_TRANSACTION)) {
			//	totalMoney = moneyAfterPurchase;
				df2.setRoundingMode(RoundingMode.UP);
			
				String logThis = "GIVE CHANGE: $" + String.valueOf(totalMoney) + " $0.00";
				log.log(logThis);
			 
				totalMoney *= 100;
				while (Integer.valueOf(df2.format(totalMoney)) > 0) {
				
					if(totalMoney > 25) {
						totalMoney -=  25;
						quarters ++;
					} else if(totalMoney > 10) {
						totalMoney -=  10;
						dimes ++;
					} else if(totalMoney >= 5) {
						totalMoney -=  5;
						nickels ++;
					}
				}
				System.out.println("Change: " + quarters + " quarters, " + dimes + " dimes, " + nickels + " nickels.");
				
				totalMoney = 0;
			
				return;
				}
			}
		}
		public double getTotalMoney() {
		return totalMoney;
	}
}

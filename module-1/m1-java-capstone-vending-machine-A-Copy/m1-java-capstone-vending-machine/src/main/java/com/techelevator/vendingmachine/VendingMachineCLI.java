package com.techelevator.vendingmachine;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

import com.techelevator.vendingmachine.product.VendingMachineProduct;
import com.techelevator.vendingmachine.view.Menu;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	//sf:Add Exit option
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	
	//sf: add Display Sales report
	private static final String MAIN_MENU_OPTION_DISPLAY_SALES_REPORT = "Display Sales Report";
	
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT, MAIN_MENU_OPTION_DISPLAY_SALES_REPORT };

	private Menu menu;

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}
	
	

	public void run() {
		
		//sf: create and instantiate VendingMachine (vm) Object
		//String inventoryList = "C:\\Users\\Student\\workspace\\java-module-1-capstone-team-6\\module-1\\capstone\\java\\src\\main\\resources\\vendo_stocks.txt";
		String inventoryList = "C:\\Users\\Student\\Downloads\\m1-java-capstone-vending-machine-A-Copy\\m1-java-capstone-vending-machine\\vendingmachine.csv";
		
		//sf: invoke VML to get a new VM instance 
		VendingMachineLoader vml = new VendingMachineLoader();
				
		//and load it with the inventory list
		VendingMachine vm = vml.reStock(inventoryList);
		
		
		//use and manipulate vm instance based on what the user wants
		//purchase feature...
		
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				// display vending machine items
				
				Iterator<VendingMachineProduct> iter =  vm.getVendoProducts().values().iterator();
				
				while( iter.hasNext() ) {
					VendingMachineProduct vmp = (VendingMachineProduct) iter.next();
						
					if(vmp.getQuantity() < 1) {
						if(vmp.getName().equals("Little League Chew")) {
							System.out.println("Product " + vmp.getName() + "\t| SOLD OUT");
						} else if(vmp.getName().equals("U-Chews") || vmp.getName().equals("Cola") || vmp.getName().equals("Moonpie") || vmp.getName().equals("Heavy")) {
							System.out.println("Product " + vmp.getName() + "\t\t\t| SOLD OUT");
						} else {
							System.out.println("Product " + vmp.getName() + "\t\t| SOLD OUT");
						}
					} else {
						if(vmp.getName().equals("Little League Chew")) {
							System.out.println("Product " + vmp.getName() + "\t| Quantity " + vmp.getQuantity());
						} else if(vmp.getName().equals("U-Chews") || vmp.getName().equals("Cola") || vmp.getName().equals("Moonpie") || vmp.getName().equals("Heavy")) {
							System.out.println("Product " + vmp.getName() + "\t\t\t| Quantity " + vmp.getQuantity());
						} else {
							System.out.println("Product " + vmp.getName() + "\t\t| Quantity " + vmp.getQuantity());
						}
					}
				}
				
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				// call new class Purchase Menu and run it
				Menu menu = new Menu(System.in, System.out);
				//PurchaseMenu nextMenu = new PurchaseMenu(menu);
				PurchaseMenu nextMenu = new PurchaseMenu(menu, vm.getVendoProducts());
				nextMenu.run();
				
			} else if (choice.equals(MAIN_MENU_OPTION_EXIT)) { //sf: added exit menu
				// do exit
				System.out.println("Thank you for choosing Vendo-Matic 800!");
				System.exit(0);
			} else if (choice.equals(MAIN_MENU_OPTION_DISPLAY_SALES_REPORT)) { //sf: added display report menu
				// do sales report
				System.out.println("--------------------------------");
				System.out.println("Sales report of Vendo-Matic 800:");
				System.out.println("--------------------------------");

			}
		}
	}

	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}
}

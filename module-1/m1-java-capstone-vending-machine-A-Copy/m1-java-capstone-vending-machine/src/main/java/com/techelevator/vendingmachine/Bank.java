package com.techelevator.vendingmachine;

import java.util.Scanner;
//sub-menu for accepting, processing the money feed by the user
public class Bank {
	static int totalFed = 0;
	
	private int bill;
	private int amountOfBill = 0;
	
	public Bank(String dollar, int amount) {
		
	}
	
	public double moneyFed() {
		while(true) {
			System.out.println("What type of bill are you giving? ($1, $2, $5, $10): ");
			int bill = 0;
			String billInput = "";
		
			Scanner userInput = new Scanner(System.in);
			billInput = userInput.next();
			
			if(billInput.equals("1") || billInput.equals("2") || billInput.equals("5") || billInput.equals("10")) {
				bill = Integer.valueOf(billInput);
		
			} else if(billInput.isEmpty()){
				System.out.println(billInput + " is not a valid bill, please input $1, $2, $5, or $10");
				return 0;
			} else {
				System.out.println(billInput + " is not a valid bill, please input $1, $2, $5, or $10");
				return 0;
			}
		
			System.out.println("How many of this bill? ");
		
			String amountInput = userInput.next();
			amountOfBill = Integer.valueOf(amountInput);
		
			if(Integer.valueOf(amountInput) < 20) {
				totalFed = (bill * amountOfBill);

				return totalFed;

			} else {
				System.out.println(billInput + " is not a valid amount, cannot input more than 20 bills at once.");
				
			}

		}

	}

}
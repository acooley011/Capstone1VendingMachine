package com.techelevator.vendingmachine;

import java.util.Scanner;
//sub-menu for accepting, processing the money feed by the user
public class Bank {
	static int totalFed = 0;
	
	private String dollar;
	private int amount;
	
	public Bank(String dollar, int amount) {
		this.dollar = dollar;
		this.amount = amount;
	}
	
	public double moneyFed() {
		System.out.println("What type of bill are you giving? ($1, $2, $5, $10): ");
		Scanner userInput = new Scanner(System.in);
		String billInput = userInput.next();
		int bill = 0;
		
		try {
			bill = Integer.valueOf(billInput);
			
		} catch (Exception e) {
			System.out.println(bill + " is not a valid bill, please input $1, $2, $5, or $10");
			
		}
		
		System.out.println("How many of this bill? ");
		String amountInput = userInput.next();
		int amountOfBill = 0;
		
		try {
			amountOfBill = Integer.valueOf(amountInput);
			
		} catch (Exception e) {
			System.out.println(amountOfBill + " is not a valid amount");
			
		}
		
		totalFed = (bill * amountOfBill);
		
		
		
		return totalFed;
	}

}

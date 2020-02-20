package com.techelevator;

import java.util.*;

public class mainScreen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner userInput =  new Scanner(System.in);
		
		System.out.println("(1) Display Vending Machine Items");
		System.out.println("(2) Purchase");
		System.out.println("(3) Exit");
		String choice = userInput.nextLine();
		
		if(choice.equals("1")) {
			//loop through list created by the input file.
			System.out.print(/*getName quantity = 5*/"");
		} else if (choice.equals("2")) {
			
		}
	}

}

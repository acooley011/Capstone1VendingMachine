package com.techelevator.vendingmachine;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Logger {

	public Logger() {
		// TODO Auto-generated constructor stub
	}
	
	public void log(String logThis){
		//creates a new file at the path. we will have to make this gettable for other classes if we want them to update it
		
		 DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
	     Date today = Calendar.getInstance().getTime();
	     String reportDate = df.format(today);
		
			{
			try {
				
				File log = new File("C:\\Users\\Student\\Downloads\\m1-java-capstone-vending-machine-A-Copy\\m1-java-capstone-vending-machine\\Log.txt");	
				BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(log, true));

		        bufferedWriter.write(reportDate + "||" + logThis);
		        bufferedWriter.newLine();

		        bufferedWriter.close();
				

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
			
	}

}

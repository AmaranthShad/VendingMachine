package com.techelevator;

// Menu is provided to you as a suggested class to handle user input
// Build out a menu class to start

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE };

	private Menu menu;

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public static void main(String[] args) {
		// You will need to create a Menu class to handle display.
		//Menu menu = new Menu();
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}

	public void run() {
		while (true) {
			// Use a method from your Menu class to initialize this value
			String choice = "initialize this here";

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				// display vending machine items
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				// do purchase
			}
			else{
				break;
			}
		}
	}

	public List<VendingItem> loadItems(){
		File inputFile = new File("main.csv"); //taking in main.csv
		List<VendingItem> vendingItems = new ArrayList<>(); //creating list for items to go in


		try{
			Scanner input = new Scanner(inputFile); //scanner to read file
			while(input.hasNextLine()){ //loop to check if there is another line of data to read
				String nextLine = input.nextLine(); //variable for the next line
				VendingItem itemSpecs = parseItem(nextLine);
				vendingItems.add(itemSpecs);
			}
		} catch (FileNotFoundException e){
			throw new RuntimeException(e);
		}

	return null;
	}


	public VendingItem parseItem(String nextLine) {
		String[] itemSpecs = nextLine.split(","); // turning line of data into string array and splitting into 4 items
		itemSpecs[0] =
	}



}

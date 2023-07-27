package com.techelevator;

// Menu is provided to you as a suggested class to handle user input
// Build out a menu class to start

import java.io.File;
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
		File inputFile = new File("main.csv");
		List<VendingItem> vendingItems = new ArrayList<>();


		try{
			Scanner input = new Scanner(inputFile);
			while(input.hasNextLine()){
				String nextLine = input.nextLine();
				nextLine.split(",");
				loadItems.add();
			}
		}


	}
}

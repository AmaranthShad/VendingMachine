package com.techelevator;

// Menu is provided to you as a suggested class to handle user input
// Build out a menu class to start

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE };

	private Menu menu;

	private Map<String, List<VendingItem>> inventory;

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
		inventory = loadItems();
	}

	public Map<String, List<VendingItem>> loadItems(){
		File inputFile = new File("main.csv"); //taking in main.csv
		Map<String, List<VendingItem>> vendingItems = new HashMap<>(); //creating list for items to go in


		try{
			Scanner input = new Scanner(inputFile); //scanner to read file
			while(input.hasNextLine()){ //loop to check if there is another line of data to read
				String nextLine = input.nextLine(); //variable for the next line
				List<VendingItem> slotsItems = new ArrayList<>();
				for (int i = 0; i < 5; i++) {
					slotsItems.add(getItem(nextLine));
				}
				String slot = getItem(nextLine).getSlot();
				vendingItems.put(slot, slotsItems);
			}
		} catch (FileNotFoundException e){
			throw new RuntimeException(e);
		}

	return vendingItems;
	}


	public VendingItem getItem(String nextLine) {
		String[] itemSpecs = nextLine.split(","); // turning line of data into string array and splitting into 4 items
		String slot = itemSpecs[0];
		String name = itemSpecs[1];
		Double cost = Double.parseDouble(itemSpecs[2]);
		String type = "";
		type = itemSpecs[3];

		VendingItem item = null;
		switch (type) {
			case "Gum":
				item = new Gum(slot, name, cost); break;
			case "Drink":
				item = new Drink(slot, name, cost); break;
			case "Candy":
				item = new Candy(slot, name, cost); break;
			case "Munchy":
				item = new Munchy(slot, name, cost); break;
		}

		return item;
	}

	public VendingItem selectItem(String slot){
		//slot will be the key
		//check if slot exists
		//check if slot has items left(list of 5 of that item)
	}

}

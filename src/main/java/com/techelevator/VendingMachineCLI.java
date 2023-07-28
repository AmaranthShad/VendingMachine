package com.techelevator;

// Menu is provided to you as a suggested class to handle user input
// Build out a menu class to start

import java.io.File;
import java.io.FileNotFoundException;
import java.text.NumberFormat;
import java.util.*;
import java.util.List;

public class VendingMachineCLI {

    private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
    private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
    private static final String[] MAIN_MENU_OPTIONS = {MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE};
    private final Menu menu;
    private Map<String, List<VendingItem>> inventory;
    private Map<String, VendingItem> index;
    private final Scanner userInput = new Scanner(System.in);
    private double balance = 0;
    private static final String OPTION_1 = "Feed Money";
    private static final String OPTION_2 = "Select Product";
    private static final String OPTION_3 = "Finish Transaction";
    private static final String[] PURCHASE_MENU_OPTIONS = {OPTION_1, OPTION_2, OPTION_3};

    public VendingMachineCLI(Menu menu) {
        this.menu = menu;
    }

    public static void main(String[] args) {
        // You will need to create a Menu class to handle display.
        Menu menu = new Menu(System.in, System.out);
        VendingMachineCLI cli = new VendingMachineCLI(menu);
        cli.run();
    }

    public void run() {
        inventory = loadItems();
        index = indexItems();
        while (true) {
            // Use a method from your Menu class to initialize this value
            Object choice = menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

            if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
                displayAllItems();
            } else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
                purchaseMenu();
            } else {
                break;
            }
        }

    }

    //print line asking them to enter choice 1,2,or 3 1 displays displayAllItems() and has another scanner that asks them if they would like to return to main menu or exit
    public void displayAllItems() {
        for (Map.Entry<String, VendingItem> element : index.entrySet()) {
            VendingItem item = element.getValue();
            String slot = item.getSlot();
            String name = item.getName();
            String quantity = getQuantity(slot);

            System.out.println(slot + " : " + name + " " + getFormattedCost(slot) + " | " + quantity);
        }


    }


    private boolean purchaseInStock(String slot) {
        VendingItem item = index.get(slot);
        return false;
    }

    private Map<String, VendingItem> indexItems() {
        Map<String, VendingItem> index = new HashMap<>();
        for (Map.Entry<String, List<VendingItem>> element : inventory.entrySet()) {
            List<VendingItem> list = element.getValue();
            VendingItem item = list.get(0);
            String slot = item.getSlot();
            index.put(slot, item);
        }
        return index;
    }

    private String getFormattedCost(String code) {
        VendingItem item = index.get(code);
        double money = item.getPurchasePrice();
        NumberFormat formatter = NumberFormat.getCurrencyInstance();

        return formatter.format(money);
    }

    public Map<String, List<VendingItem>> loadItems() {
        File inputFile = new File("main.csv"); //taking in main.csv
        Map<String, List<VendingItem>> vendingItems = new HashMap<>(); //creating list for items to go in


        try {
            Scanner input = new Scanner(inputFile); //scanner to read file
            while (input.hasNextLine()) { //loop to check if there is another line of data to read
                String nextLine = input.nextLine(); //variable for the next line
                List<VendingItem> slotsItems = new ArrayList<>();
                for (int i = 0; i < 5; i++) {
                    slotsItems.add(getItem(nextLine));
                }
                String slot = getItem(nextLine).getSlot();
                vendingItems.put(slot, slotsItems);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return vendingItems;
    }

    public String getQuantity(String slot) {
        int quantity = inventory.get(slot).size();
        if (quantity == 0)
            return "SOLD OUT";
        return String.valueOf(quantity);
    }

    public VendingItem getItem(String nextLine) {
        String[] itemSpecs = nextLine.split(","); // turning line of data into string array and splitting into 4 items
        String slot = itemSpecs[0];
        String name = itemSpecs[1];
        double cost = Double.parseDouble(itemSpecs[2]);
        String type = "";
        type = itemSpecs[3];

        VendingItem item = null;
        switch (type) {
            case "Gum":
                item = new Gum(slot, name, cost);
                break;
            case "Drink":
                item = new Drink(slot, name, cost);
                break;
            case "Candy":
                item = new Candy(slot, name, cost);
                break;
            case "Munchy":
                item = new Munchy(slot, name, cost);
                break;
        }

        return item;
    }

    private void purchaseMenu() {
        while (true) {
            System.out.println("Current money provided: " + 12);
            // Use a method from your Menu class to initialize this value
            Object choice = menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);

            if (choice.equals(OPTION_1)) {
                //FEED MONEY
            } else if (choice.equals(OPTION_2)) {
                displayAllItems();
                selectProductInPurchase();
            } else if (choice.equals(OPTION_3)) {
                //finish transaction
            } else {
                break;
            }
        }

    }

//    private void feedMoney() {
//        System.out.println("Current money provided: " + cashRegister.getBalance());
//        System.out.println("Feed in more money: ");
//        double addedMoney = input.nextLine();
//        cashRegister.getBalance() += addedMoney;
//        System.out.println("Updated current money: " + cashRegister.getBalance());
//    }

    private void selectProductInPurchase() {
        System.out.println("Please make a selection: ");
        String slot = userInput.nextLine();
        if(!index.containsKey(slot)){
            System.out.println("The selection you entered does not exist.");
            return;
        }
        if(getQuantity(slot).equals("SOLD OUT")){
            System.out.println("The selection you entered is SOLD OUT.");
            return;
        }
        VendingItem item = index.get(slot);
        String name = item.getName();
        String cost = getFormattedCost(slot);
        String quantity = getQuantity(slot);
        System.out.println("The selection you made: " + name + " costs " + cost + " | There are " + quantity + " remaining in stock.");



    }


}

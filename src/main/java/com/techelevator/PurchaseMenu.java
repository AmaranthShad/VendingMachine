package com.techelevator;

public class PurchaseMenu {

   public something purchaseMenuChoice(){
       double currentMoney = 0.0;
       System.out.println(currentMoney);
       System.out.println("(1) Feed Money");
       System.out.println("(2) Select Product");
       System.out.println("(3) Finish Transaction");
       String purchaseMenuOption = in.nextLine();
       if(purchaseMenuOption = "1"){
           System.out.println(currentMoney);
           System.out.println("Please feed money: ");
           double moneyAdded = scanner.in;
           currentMoney += moneyAdded;
           System.out.println(currentMoney);
       }
       if(purchaseMenuOption = "2"){
           productChoice();
       }

   }

   public object productChoice(String slot) {
    displayAllItems();
    String slot = in.nextLine();
       if (slot exists){
           System.out.println("The selection you made: " + item.getName() + " costs " + item.getCost() + "There are " + item.getQuantity() + "remaining in stock.");
       }
    else{
           System.out.println("The selection you entered does not exist.");
           return to purchase menu;
       }
   }

}

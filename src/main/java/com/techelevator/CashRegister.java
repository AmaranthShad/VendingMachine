package com.techelevator;

import java.text.NumberFormat;

public class CashRegister {
    private double balance;

    public CashRegister() {
        balance = 0.0;
    }

    public double getBalance(){
        return balance;
    }
    public String getFormattedBalance() {
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        return formatter.format(balance);
    }
    public void addToBalance(double money){
        if (money< 0.0){
            System.out.println("You can't trick me with your negative money");
            return;
        }
        balance += money;
    }
    public void getChange(){
        int quarters = 0;
        int dimes = 0;
        int nickels = 0;
        while (balance > 0.25){
            balance -= 0.25;
            quarters++;
        }
        while (balance > 0.10){
            balance -= 0.10;
            dimes++;
        }
        while (balance > 0.05){
            balance -= 0.05;
            nickels++;
        }
        System.out.print("Your change is: ");
        if (quarters>0)
            System.out.print(quarters + " quarter(s) ");
        if (dimes>0)
            System.out.print(dimes + " dime(s) ");
        if (nickels>0)
            System.out.print(nickels + " nickel(s) ");
        balance = 0;
    }

    public void subtractPurchase(double cost){
        balance -= cost;
    }
}



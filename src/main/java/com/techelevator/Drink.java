package com.techelevator;

public class Drink extends VendingItem{
    public Drink(String slot, String name, double cost) {
        super(slot, name, cost);
    }

    @Override
    public void getEaten() {
        System.out.println("Glug Glug, Yum!");
    }
}

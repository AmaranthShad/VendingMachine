package com.techelevator;

public class Candy extends VendingItem{
    public Candy(String slot, String name, double cost) {
        super(slot, name, cost);
    }

    @Override
    public void getEaten() {
        System.out.println("Yummy Yummy, So Sweet!");
    }
}

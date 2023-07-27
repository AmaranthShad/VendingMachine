package com.techelevator;

public class Gum extends VendingItem{
    public Gum(String slot, String name, double cost) {
        super(slot, name, cost);
    }

    @Override
    public void getEaten() {
        System.out.println("Chew Chew, Yum!");
    }
}

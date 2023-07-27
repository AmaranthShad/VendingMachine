package com.techelevator;

public class Munchy extends VendingItem{
    public Munchy(String slot, String name, double cost) {
        super(slot, name, cost);
    }

    @Override
    public void getEaten() {
        System.out.println("Crunch Crunch, Yum!");
    }
}

package com.techelevator;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class VendingItem {
    private final String slot;
    private final String name;
    private final double cost;

    public VendingItem(String slot, String name, double cost) {
        this.slot = slot;
        this.name = name;
        this.cost = cost;
    }

    public String getSlot() {
        return slot;
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }

//    public double getPurchasePrice(){
//        if (isDiscounted){
//            return getCost() - 1.0;
//        }
//        return getCost();
//    }
    public abstract void getEaten();

}

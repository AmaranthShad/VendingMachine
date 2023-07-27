package com.techelevator;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class VendingItem {
    private String slot;
    private String name;
    private double cost;

    public VendingItem(){

    }

    public VendingItem(String slot, String name, double cost) {
        this.slot = slot;
        this.name = name;
        this.cost = cost;
    }

    public String getSlot() {
        return slot;
    }

    public void setSlot(String slot) {
        this.slot = slot;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public abstract void getEaten();

}

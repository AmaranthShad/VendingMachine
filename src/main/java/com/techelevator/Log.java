package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;
import java.util.Set;

import static java.lang.System.exit;

public class Log {

    private final File log;
    public Log() {
        this.log = new File("Log.txt");
        if (!log.exists()) {
            return;
        }
        String time = LocalTime.now().toString();
        time = time.substring(0, time.lastIndexOf("."));
        time = time.replaceAll(":", "-");
        String oldLogName = LocalDate.now().toString() + "_" + time + "log.txt";
        File oldLog = new File(oldLogName);
        if (!log.renameTo(oldLog)) {
            System.out.println("Uh oh can't delete old log");
        }
    }

    public static void generateSalesReport(Set<VendingItem> index){
        String ld = String.valueOf(LocalDate.now());
        String lt = String.valueOf(LocalTime.now());
        lt = lt.substring(0,lt.lastIndexOf(".")).replaceAll(":", "-");
        File salesReport = new File(ld+"_"+lt+"salesReport.txt");
        try(PrintWriter writer = new PrintWriter(salesReport)){
            double totalSales = 0;
            for (VendingItem vendingItem : index) {
                String name = vendingItem.getName();
                int regularPurchases = vendingItem.getRegularPurchase();
                int discountedPurchases = vendingItem.getDiscountedPurchase();
                String message = name + "|" +
                        regularPurchases + "|" +
                        discountedPurchases;
                writer.println(message);
                double revenue = regularPurchases+discountedPurchases;
                revenue *= vendingItem.getCost();
                revenue -= discountedPurchases;
                totalSales += revenue;
            }
            String revenue = NumberFormat.getCurrencyInstance().format(totalSales);
            writer.println("\r\n**TOTAL SALES** " + revenue);
        }catch (FileNotFoundException e){
            System.out.println("SalesReport file not found for writing");
        }
    }

    public void printNext(String newLine){
        File temp = new File("tmp");
        try (PrintWriter output = new PrintWriter(temp)) {
            if (!log.exists()) {
                output.println(newLine);
                output.close();
                if (!temp.renameTo(log)){
                    System.out.println("Failed to save file!");
                    exit(1);
                }
                return;
            }
            try (Scanner reader = new Scanner(log)) {
                while (reader.hasNextLine()) {
                    String oldLine = reader.nextLine();
                    output.println(oldLine);
                }
            } catch (FileNotFoundException e) {
                System.out.println("Can't find log file");
                exit(1);
            }
            output.println(newLine);
        }catch (IOException e){
            System.out.println("Can't create temp file");
            exit(1);
        }
        if (!log.delete()){
            System.out.println("Can't delete");
            exit(1);
        }
        if (!temp.renameTo(log)){
            System.out.println("Can't create new log");
            exit(1);
        }
    }
}

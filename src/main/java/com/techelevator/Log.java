package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

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

    public void printNext(String newLine){
        File temp = null;
        temp = new File("tmp");
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

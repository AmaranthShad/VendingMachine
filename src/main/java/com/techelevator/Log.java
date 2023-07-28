package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Log {

    private File log;
    public Log() {
        this.log = new File("Log.txt");
    }

    private void run(){
        String toBePrinted = "";
        try{
            PrintWriter output = new PrintWriter(log);
            output.println(toBePrinted);
        }catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

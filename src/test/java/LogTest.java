import com.techelevator.Log;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static java.lang.System.exit;

public class LogTest {
    public Log testObj;
    public File file;
    @Before
    public void setup(){
        testObj = new Log();
        file=new File("log.txt");
        if (!file.delete()){
            System.out.println("aaaaaaaaaaaaaaaaa");
        }
    }
    @Test
    public void writeOneLine(){
        String line = "this is line 1";
        testObj.printNext(line);
        String expected = "this is line 1\r\n";
        String actual = fileToString();
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void writeTwoLines(){
        String line = "this is line 1";
        String line2 = "this is line 2";
        testObj.printNext(line);
        testObj.printNext(line2);
        String expected = "this is line 1\r\nthis is line 2\r\n";
        String actual = fileToString();
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void writeThreeLines(){
        String line = "this is line 1";
        String line2 = "this is line 2";
        String line3 = "this is line 3";
        testObj.printNext(line);
        testObj.printNext(line2);
        testObj.printNext(line3);
        String expected = "this is line 1\r\nthis is line 2\r\nthis is line 3\r\n";
        String actual = fileToString();
        Assert.assertEquals(expected, actual);
    }

    public String fileToString(){
        StringBuilder building = new StringBuilder();
        try (Scanner reader = new Scanner(file)){
            while (reader.hasNextLine()){
                building.append(reader.nextLine()+"\r\n");
            }
        }catch (FileNotFoundException e){
            System.out.println("lost file");
            exit(1);
        }
        return building.toString();
    }





}

package com.techelevator;
import com.techelevator.VendingItem;
import com.techelevator.Candy;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
public class CandyTest {
    public Candy testObj;
    @Before
    public void setup(){
        testObj = new Candy("A4", "testDrop", 9.999);
    }

    @Test
    public void testSlot(){
        String actual = testObj.getSlot();
        String expected = "A4";
        Assert.assertEquals("Does not return correct slot", expected, actual);
    }
    @Test
    public void testName(){
        String actual = testObj.getName();
        String expected = "testDrop";
        Assert.assertEquals("Does not return correct name", expected, actual);
    }
    @Test
    public void testCost(){
        double actual = testObj.getCost();
        double expected = 9.999;
        Assert.assertEquals("Does not return correct cost", expected, actual, 0.1);
    }
    @Test
    public void testPurchaseCounter(){
        testObj.addRegularPurchase();
        testObj.addRegularPurchase();
        testObj.addRegularPurchase();
        testObj.addDiscountedPurchase();
        testObj.addDiscountedPurchase();
        int actual = testObj.getRegularPurchase();
        int expected = 3;
        Assert.assertEquals("Does not return correct count", expected, actual);
        actual = testObj.getDiscountedPurchase();
        expected = 2;
        Assert.assertEquals("Does not return correct count", expected, actual);
    }
}

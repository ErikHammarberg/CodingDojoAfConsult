/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.security.InvalidParameterException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import library.StringCalculator;
import org.junit.Assert;


/**
 *
 * @author slaeggan
 */


public class StringCalculatorTest {
    StringCalculator stringCalculator;

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        stringCalculator = new StringCalculator();
    }

    @Test
    public void emptyString() {
        org.junit.Assert.assertEquals(0, stringCalculator.add(""));
        
    }

    @Test
    public void addOneNumber(){
        org.junit.Assert.assertEquals(2, stringCalculator.add("2"));
    }

    @Test
    public void addThreeNumbers(){
        Assert.assertEquals(6, stringCalculator.add("1,2,3"));
    }

    @Test
    public void addTwoNumbersWithMixedDelimiters() {
        Assert.assertEquals(6, stringCalculator.add("1,2\n3"));
    }

    @Test
    public void addTwoNumbersWithNewDelimiter() {
        Assert.assertEquals(4, stringCalculator.add("//;;\n3;;1"));
    }

    @Test 
    public void addNegativeNumbers() {
        try {
            stringCalculator.add("2,-3,8,-3\n9\n-2");
            Assert.fail();
        }
        catch (InvalidParameterException ex) {
            //Assert.assertEquals(stringCalculator, ex.getCause().getClass());
            Assert.assertEquals("negatives not allowed: -3 -3 -2", ex.getMessage());
        }
    }
    @After
    public void tearDown() throws Exception {
    }

}
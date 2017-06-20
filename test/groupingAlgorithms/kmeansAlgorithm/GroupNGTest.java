/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package groupingAlgorithms.kmeansAlgorithm;

import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Helder Faria 1140816@isep.ipp.pt
 */
public class GroupNGTest {

    Group instance;

    public GroupNGTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
        int[] numbers = {160, 15, 14, 13, 34, 23, 24, 25, 26, 28, 45, 34, 23, 29, 12, 23, 45, 67, 23, 12, 34, 45, 23,
            67, 23, 670};
        instance = new Group(30);
        for (int i = 0; i < numbers.length; i++) {
            instance.addValue(new Value(numbers[i]));
        }
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }

    /**
     * Test of clear method, of class Group.
     */
    @Test
    public void testClear() {
        System.out.println("clear");

        instance.clear();
        
        assertEquals(instance.getValuesArray().length, 0);
    }

    /**
     * Test of distanceToCentroid method, of class Group.
     */
    @Test
    public void testDistanceToCentroid() {
        System.out.println("distanceToCentroid");
        
        int value = 5;
        double expResult = 25.0;
        double result = instance.distanceToCentroid(value);
        assertEquals(result, expResult, 0.0);
        
        
        value = -5;
        expResult = 35.0;
        result = instance.distanceToCentroid(value);
        assertEquals(result, expResult, 0.0);
        
        value = 35;
        expResult = 5.0;
        result = instance.distanceToCentroid(value);
        assertEquals(result, expResult, 0.0);
    }

    /**
     * Test of addValue method, of class Group.
     */
    @Test
    public void testAddValue() {
        System.out.println("addValue");
        
        Value value = new Value(5);

        boolean expResult1 = true;
        boolean result1 = instance.addValue(value);
        
        int length = instance.getValuesArray().length;
        int expResult2 = 5;
        int result2 = instance.getValuesArray()[length-1];
   
        assertEquals(result1, expResult1);
        assertEquals(result2, expResult2);
    }

    /**
     * Test of updateCentroid method, of class Group.
     */
    @Test
    public void testUpdateCentroid() {
        System.out.println("updateCentroid");
        Group instance = null;
        double expResult = 0.0;
        double result = instance.updateCentroid();
        assertEquals(result, expResult, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of centroidsConverged method, of class Group.
     */
    @Test
    public void testCentroidsConverged() {
        System.out.println("centroidsConverged");
        double margin = 0.0;
        Group instance = null;
        boolean expResult = false;
        boolean result = instance.centroidsConverged(margin);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getValuesArray method, of class Group.
     */
    @Test
    public void testGetValuesArray() {
        System.out.println("getValuesArray");
        Group instance = null;
        int[] expResult = null;
        int[] result = instance.getValuesArray();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}

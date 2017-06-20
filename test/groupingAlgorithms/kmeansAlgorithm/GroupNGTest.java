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
 * @author helderjf
 */
public class GroupNGTest {

    Group t_group;

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
        t_group = new Group(30);
        for (int i = 0; i < numbers.length; i++) {
            t_group.addValue(new Value(numbers[i]));
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

        t_group.clear();

        assertEquals(t_group.getValuesArray().length, 0);
    }

    /**
     * Test of distanceToCentroid method, of class Group.
     */
    @Test
    public void testDistanceToCentroid() {
        System.out.println("distanceToCentroid");

        int value = 5;
        double expResult = 25.0;
        double result = t_group.distanceToCentroid(value);
        assertEquals(result, expResult, 0.0);

        value = -5;
        expResult = 35.0;
        result = t_group.distanceToCentroid(value);
        assertEquals(result, expResult, 0.0);

        value = 35;
        expResult = 5.0;
        result = t_group.distanceToCentroid(value);
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
        boolean result1 = t_group.addValue(value);

        int length = t_group.getValuesArray().length;
        int expResult2 = 5;
        int result2 = t_group.getValuesArray()[length - 1];

        assertEquals(result1, expResult1);
        assertEquals(result2, expResult2);
    }

    /**
     * Test of updateCentroid method, of class Group.
     */
    @Test
    public void testUpdateCentroid() {
        System.out.println("updateCentroid");

        Group instance = new Group(5);//centroid is 5
        instance.addValue(new Value((10)));

        instance.updateCentroid();
        double distanceToCentroid = instance.distanceToCentroid(10);//should be 0
        assertEquals(distanceToCentroid, 0.0);

        instance.addValue(new Value((100)));
        instance.updateCentroid();
        distanceToCentroid = instance.distanceToCentroid(5);//should be 50
        assertEquals(distanceToCentroid, 50.0);
    }

    /**
     * Test of centroidsConverged method, of class Group.
     */
    @Test
    public void testCentroidsConverged() {
        System.out.println("centroidsConverged");
        
        Group instance = new Group(5);//centroid is 5

        instance.addValue(new Value(100));
        instance.updateCentroid();//should update to 100
        boolean expResult = false;
        boolean result = instance.centroidsConverged(0);
        assertEquals(result, expResult);
        
        instance.updateCentroid();// should remain 100
        expResult = true;
        result = instance.centroidsConverged(0);
        assertEquals(result, expResult);
    }

    /**
     * Test of getValuesArray method, of class Group.
     */
    @Test
    public void testGetValuesArray() {
        System.out.println("getValuesArray");
        
        int[] expResult = {160, 15, 14, 13, 34, 23, 24, 25, 26, 28, 45, 34, 23, 29, 12, 23, 45, 67, 23, 12, 34, 45, 23,
            67, 23, 670};
        
        int[] result = t_group.getValuesArray();
        assertEquals(result, expResult);

    }

}

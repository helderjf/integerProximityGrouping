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
public class ValueNGTest {
    
    private Value t_value;
    
    public ValueNGTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
        t_value = new Value(10);
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }

    /**
     * Test of getValue method, of class Value.
     */
    @Test
    public void testGetValue() {
        System.out.println("getValue");
        int expResult = 10;
        int result = t_value.getValue();
        assertEquals(result, expResult);
    }
    
}

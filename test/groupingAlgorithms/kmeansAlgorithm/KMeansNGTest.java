/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package groupingAlgorithms.kmeansAlgorithm;

import java.util.Arrays;
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
public class KMeansNGTest {

    private KMeans t_kmeans;
    private int[] t_values1 = {160, 15, 14, 13, 34, 23, 24, 25, 26, 28, 45, 34, 23, 29, 12, 23, 45, 67, 23, 12, 34, 45, 23,
        67, 23, 670};
    private int[] t_values2 = {1, 2, 3, 11, 12, 13, 21, 22, 23};

    private int t_numberOfGroups1 = 4;
    private int t_numberOfGroups2 = 3;

    public KMeansNGTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {

        t_kmeans = new KMeans();

    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }

    /**
     * Test of init method, of class KMeans.
     */
    @Test
    public void testInit() {
        System.out.println("init");

        t_kmeans.init(t_values1, t_numberOfGroups1);
        int[][] actualSolution = t_kmeans.getSolution();
        int[][] expectedSolution = null;//no solution befor calculating

        assertEquals(actualSolution, expectedSolution);
    }

    /**
     * Test of calculate method, of class KMeans.
     */
    @Test
    public void testCalculate() {
        System.out.println("calculate");

        int[][] actualSolution = t_kmeans.getSolution();
        assertTrue(actualSolution == null, "Solution shouldn't exist yet");

        t_kmeans.init(t_values2, t_numberOfGroups2);
        t_kmeans.calculate();
        actualSolution = t_kmeans.getSolution();
        t_kmeans.printSolution();

        int[][] candidateSolution1 = {{1, 2, 3}, {11, 12, 13}, {21, 22, 23}};
        int[][] candidateSolution2 = {{1, 2, 3}, {21, 22, 23}, {11, 12, 13}};
        int[][] candidateSolution3 = {{11, 12, 13}, {1, 2, 3}, {21, 22, 23}};
        int[][] candidateSolution4 = {{11, 12, 13}, {21, 22, 23}, {1, 2, 3}};
        int[][] candidateSolution5 = {{21, 22, 23}, {1, 2, 3}, {11, 12, 13}};
        int[][] candidateSolution6 = {{21, 22, 23}, {11, 12, 13}, {1, 2, 3}};

        boolean correctSolution
                = Arrays.deepEquals(actualSolution, candidateSolution1)
                || Arrays.deepEquals(actualSolution, candidateSolution2)
                || Arrays.deepEquals(actualSolution, candidateSolution3)
                || Arrays.deepEquals(actualSolution, candidateSolution4)
                || Arrays.deepEquals(actualSolution, candidateSolution5)
                || Arrays.deepEquals(actualSolution, candidateSolution6);

        //the solution is no One Correct solution,
        //so it's hard to test for the rightness of the calculation
        //in more complex cases
        assertTrue(correctSolution, "Solutions difers from expected");

    }

    /**
     * Test of getSolution method, of class KMeans.
     */
    @Test
    public void testGetSolution() {
        System.out.println("getSolution");

        int[][] actualSolution = t_kmeans.getSolution();
        assertTrue(actualSolution == null, "Solution shouldn't exist yet");

        t_kmeans.init(t_values2, t_numberOfGroups2);
        t_kmeans.calculate();
        actualSolution = t_kmeans.getSolution();
        t_kmeans.printSolution();


        int[][] candidateSolution1 = {{1, 2, 3}, {11, 12, 13}, {21, 22, 23}};
        int[][] candidateSolution2 = {{1, 2, 3}, {21, 22, 23}, {11, 12, 13}};
        int[][] candidateSolution3 = {{11, 12, 13}, {1, 2, 3}, {21, 22, 23}};
        int[][] candidateSolution4 = {{11, 12, 13}, {21, 22, 23}, {1, 2, 3}};
        int[][] candidateSolution5 = {{21, 22, 23}, {1, 2, 3}, {11, 12, 13}};
        int[][] candidateSolution6 = {{21, 22, 23}, {11, 12, 13}, {1, 2, 3}};

        boolean correctSolution
                = Arrays.deepEquals(actualSolution, candidateSolution1)
                || Arrays.deepEquals(actualSolution, candidateSolution2)
                || Arrays.deepEquals(actualSolution, candidateSolution3)
                || Arrays.deepEquals(actualSolution, candidateSolution4)
                || Arrays.deepEquals(actualSolution, candidateSolution5)
                || Arrays.deepEquals(actualSolution, candidateSolution6);

        //the solution is no One Correct solution,
        //so it's hard to test for the rightness of the calculation
        //in more complex cases
        assertTrue(correctSolution, "Solutions difers from expected");
    }

    /**
     * Test of name method, of class KMeans.
     */
    @Test
    public void testName() {
        System.out.println("name");

        String expResult = "K-Means Algorithm";
        String result = t_kmeans.name();
        assertEquals(result, expResult);
    }

}

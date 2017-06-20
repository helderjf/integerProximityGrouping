/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integerproximitygrouping;

import DAL.AlgorithmsRepository;
import groupingAlgorithms.GroupingAlgorithm;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author helderjf
 */
public class IntegerProximityGrouping {

    public static void main(String[] args) {

        int[] numbers = {160, 15, 14, 13, 34, 23, 24, 25, 26, 28, 45, 34, 23, 29, 12, 23, 45, 67, 23, 12, 34, 45, 23,
            67, 23, 670};
        int groups = 4;

        int[][] solution = group(numbers, groups);

    }

    private static int[][] group(int[] numbers, int groups) {

        //get the available algorithms
        Map<Integer, GroupingAlgorithm> algorithms = new AlgorithmsRepository().getAlgorithms();

        //chose the desired algorithm
        int chosenAlgorithmKey = chooseAlgorithm(algorithms);
        GroupingAlgorithm chosenAlgorithm = algorithms.get(chosenAlgorithmKey);

        //use the algorithm
        chosenAlgorithm.init(numbers, groups);
        chosenAlgorithm.calculate();
        int[][] solution = chosenAlgorithm.getSolution();
        chosenAlgorithm.printSolution();

        return solution;
    }

    /**
     * Prompts the user to choose the desired algorithm among the available ones
     *
     * @param algorithms Map of the available algorithms
     * @return key for the chosen algorithm
     */
    private static int chooseAlgorithm(Map<Integer, GroupingAlgorithm> algorithms) {
        Scanner scanner = new Scanner(System.in);
        Integer algorithmKey = 0;
        boolean algorithmOK = false;

        do {
            System.out.println("Please choose the algorithm you want to use for grouping the numbers");
            for (int i = 1; i <= algorithms.size(); i++) {
                System.out.println(i + ") " + algorithms.get(i).name());
            }

            String input = scanner.next();
            try {
                algorithmKey = Integer.parseInt(input);
            } catch (NumberFormatException nfe) {
                System.out.println("The value you choosed is not valid. Please try again.");
                System.out.println("-----------------");
                System.out.println("\n\n\n\n");
            }

            //check if the inserted value is among the algorithm keys
            if (algorithms.keySet().contains(algorithmKey)) {
                algorithmOK = true;
            } else {
                System.out.println("The value you choosed is not valid. Please try again.");
                System.out.println("-----------------");
                System.out.println("\n\n\n\n");
            }

        } while (!algorithmOK);

        scanner.close();

        return algorithmKey;
    }

}

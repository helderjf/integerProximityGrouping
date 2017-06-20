package groupingAlgorithms;
/**
 * Interface for the necessary methods of a grouping algorithm
 * @author helderjf
 *
 */
public interface GroupingAlgorithm {
	/**
	 * Initializes the algorithm with the initial data of the problem
	 * @param values array of integers to group
	 * @param numberOfGroups number of groups you want to group the numbers in
	 */
	public void init(int[] values, int numberOfGroups);
	
	/**
	 * Calculates the solution
	 */
	public void calculate();
	
	/**
	 * Prints the solution
	 */
	public void printSolution();
	
	/**
	 * Returns the solution
	 * @return solution as an array of integers 
	 */
	public int[][] getSolution();
	
	/**
	 * Returns the name of the algorithm
	 * @return name of the algorithm
	 */
	public String name();
}

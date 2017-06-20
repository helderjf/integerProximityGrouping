package groupingAlgorithms.kmeansAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import groupingAlgorithms.GroupingAlgorithm;

/**
 * Provides the necessary tools to group an array of integers in N groups through the KMeans algorithm
 * @author helderjf
 *
 */
public class KMeans implements GroupingAlgorithm {

	private List<Value> values;
	private int numberOfGroups;
	private List<Group> groups;
	private boolean solutionFound = false;
	private int[][] solution;

	public KMeans() {
		this.values = new ArrayList<Value>();
		this.groups = new ArrayList<Group>();
	}

	@Override
	public void init(int[] values, int numberOfGroups) {
		this.solution = new int[numberOfGroups][];
		this.numberOfGroups = numberOfGroups;
		// initialize the values list with the provided numbers
		for (int i = 0; i < values.length; i++) {
			this.values.add(new Value(values[i]));
		}

		// initialize the groups list with the provided number of groups and
		// giving each group a initial centroid, being a random value within the
		// interval of number provided;
		for (int i = 0; i < this.numberOfGroups; i++) {
			Random r = new Random();
			double centroid = minValue() + r.nextDouble() * (maxValue() - minValue());
			groups.add(new Group(centroid));
		}

	}

	/**
	 * Returns the maximum value of all the values
	 * 
	 * @return maximum value
	 */
	private int maxValue() {
		if (this.values == null) {
			return 0;
		}
		int max = Integer.MIN_VALUE;
		for (Value value : values) {
			if (value.getValue() > max) {
				max = value.getValue();
			}
		}
		return max;
	}

	/**
	 * Returns the minimum value of all the values
	 * 
	 * @return minimum value
	 */
	private int minValue() {
		if (this.values == null) {
			return 0;
		}
		int min = Integer.MAX_VALUE;
		for (Value value : values) {
			if (value.getValue() < min) {
				min = value.getValue();
			}
		}
		return min;
	}

	@Override
	public void calculate() {

		boolean converged = false;
		do {
			resetGroups();
			assignValuesToGroups();
			recalculateCentroids();
			converged = verifyConvergence();
		} while (!converged);

		solutionFound = true;

		extractSolution();

	}

	/**
	 * Clears all the values in all the groups
	 */
	private void resetGroups() {
		for (Group group : this.groups) {
			group.clear();
		}

	}

	/**
	 * Assigns each value to the closest centroid
	 */
	private void assignValuesToGroups() {

		for (Value value : values) {
			double minimalDistance = Double.MAX_VALUE;
			Group selectedGroup = null;

			for (Group group : groups) {
				//calculate distance to the group centroid
				double currentDistance = group.distanceToCentroid(value.getValue());
				//if it is less than the last minimal distance, select the current group
				if (currentDistance < minimalDistance) {
					minimalDistance = currentDistance;
					selectedGroup = group;
				}
			}
			//assign value to the selected group
			selectedGroup.addValue(value);
		}

	}

	/**
	 * recalculates all the centroids
	 */
	private void recalculateCentroids() {
		for (Group group : groups) {
			group.updateCentroid();
		}
	}

	/**
	 * Verifies if the algorithm has converged or not
	 * @return true if converged, false if not
	 */
	private boolean verifyConvergence() {
		for (Group group : groups) {
			if (!group.centroidsConverged(0)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Creates a matrix of int from the current groups list
	 */
	private void extractSolution() {
		for (int i = 0; i < groups.size(); i++) {
			solution[i] = groups.get(i).getValuesArray();
		}
	}

	@Override
	public void printSolution() {
            System.out.println("Solution:");
            for(int i=0; i<solution.length; i++){
		System.out.println(Arrays.toString(solution[i]));
            }

	}

	@Override
	public int[][] getSolution() {
		if (solutionFound) {
			return solution;
		} else {
			return null;
		}
	}

	@Override
	public String name() {
		return "K-Means Algorithm";
	}

}

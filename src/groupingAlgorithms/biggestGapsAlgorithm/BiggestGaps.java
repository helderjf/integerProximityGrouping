package groupingAlgorithms.biggestGapsAlgorithm;

import groupingAlgorithms.GroupingAlgorithm;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Provides the necessary tools to group an array of integers in N groups
 * through the BiggestGaps algorithm
 * 
 * @author helderjf
 *
 */
public class BiggestGaps implements GroupingAlgorithm {
	/**
	 * list of the values to be grouped
	 */
	private List<Value> values;
	/**
	 * list of the biggest gaps found
	 */
	private List<Gap> biggestGaps;
	/**
	 * number of group to divide the array into
	 */
	private int numberOfGroups;
	/**
	 * solution for the problem
	 */
	private int[][] solution;

	/**
	 * Creates a new biggest gaps algorithm instance
	 */
	public BiggestGaps() {
		this.biggestGaps = new ArrayList<Gap>();
		this.values = new ArrayList<Value>();
	}

	@Override
	public void init(int[] values, int numberOfGroups) {
		this.numberOfGroups = numberOfGroups;
		this.solution = new int[this.numberOfGroups][];
		for (int i = 0; i < numberOfGroups - 1; i++) {
			this.biggestGaps.add(new Gap(0, 0));
		}

		for (int i = 0; i < values.length; i++) {
			this.values.add(new Value(values[i], i));
		}
		Collections.sort(this.values);

	}

	@Override
	public void calculate() {
		calculateBiggestGaps();
		makeSolution();

	}

	/**
	 * finds the N-1 biggest gaps (N being the number of groups to divide the array into)
	 */
	private void calculateBiggestGaps() {

		for (int i = 0; i < values.size() - 1; i++) {
			int currentValue = values.get(i).getValue();
			int nextValue = values.get(i + 1).getValue();
			updateBiggestGaps(new Gap(currentValue, nextValue, i));
		}
	}

	/**
	 * Tests if a new gap makes it to the biggest gaps list and pudates the list if necessary
	 * @param gap gao to test
	 * @return
	 */
	private boolean updateBiggestGaps(Gap gap) {
		Gap smallestGap = this.getSmallestGap();
		if (smallestGap.compareTo(gap) < 1) {
			biggestGaps.add(biggestGaps.indexOf(smallestGap), gap);
			biggestGaps.remove(smallestGap);
			return true;
		}
		return false;
	}

	/**
	 * Distribute the values by the various groups taking into account the found gaps, ordering them,
	 * and creating a final solution as a matrix of integers
	 */
	private void makeSolution() {
		// order gaps by index
		Collections.sort(biggestGaps, new GapIndexComparator());

		// initialize an auxiliary temporary solution
		List<Group> tempSolution = new ArrayList<Group>();
		for (int i = 0; i < numberOfGroups; i++) {
			tempSolution.add(new Group());
		}

		// create a list of breaking points for groups
		List<Integer> breakPoins = new ArrayList<Integer>();
		for (Gap gap : biggestGaps) {
			breakPoins.add(values.get(gap.getIndex()).getValue());
		}
		breakPoins.add(values.get(values.size() - 1).getValue());

		// distribute the values by the various groups
		distributeValuesByGroups(tempSolution, breakPoins);

		// transform the tempSolution into a definite one
		extractSolutionArray(tempSolution);

	}

	/**
	 * Distribute values by their respective groups
	 * @param tempSolution auxiliary temporary solution
	 * @param breakPoins break points of the array
	 */
	private void distributeValuesByGroups(List<Group> tempSolution, List<Integer> breakPoins) {
		int aux;
		for (Value value : values) {
			aux = 0;
			for (Integer breakPoint : breakPoins) {
				if (value.getValue() <= breakPoint) {
					tempSolution.get(aux).addValue(value);
					break;
				} else {
					aux++;
				}
			}
		}
	}

	/**
	 * Transforms the temporary solution into the final one
	 * @param tempSolution auxiliary temporary solution
	 */
	private void extractSolutionArray(List<Group> tempSolution) {
		for (int i = 0; i < numberOfGroups; i++) {
			tempSolution.get(i).orderByIndex();
			solution[i] = tempSolution.get(i).getValuesArray();
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
		return solution;
	}

	@Override
	public String name() {
		return "Biggest Gaps Algorithm";
	}

	/**
	 * Returns the list of the biggest gaps found
	 * @return list of the biggest gaps
	 */
	public List<Gap> getGaps() {
		return biggestGaps;
	}

	/**
	 * tests if the biggest gaps list contains the provided gap
	 * @param gap gap
	 * @return true if the list contains the provided gap, false if not
	 */
	public boolean contains(Gap gap) {
		return biggestGaps.contains(gap);
	}

	/**
	 * Tests if the biggest gaps list contais a gap with the given index 
	 * @param gapIndex gap index
	 * @return true if the list contains the a gap with the provided index, false if not
	 */
	public boolean contains(int gapIndex) {
		for (Gap gap : biggestGaps) {
			if (gap.getIndex() == gapIndex) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Returns the current smallest gap
	 * 
	 * @return the smallest gap
	 */
	private Gap getSmallestGap() {
		if (biggestGaps.size() == 0) {
			return null;
		}
		Gap smallestGap = biggestGaps.get(0);
		for (int i = 1; i < biggestGaps.size(); i++) {
			if (biggestGaps.get(i).compareTo(smallestGap) < 0) {
				smallestGap = biggestGaps.get(i);
			}
		}
		return smallestGap;
	}

	/**
	 * Comparator for comparing Gaps based on their index
	 * @author helderjf
	 *
	 */
	private class GapIndexComparator implements Comparator<Gap> {
		@Override
		public int compare(Gap gap1, Gap gap2) {
			return gap1.getIndex() - gap2.getIndex();
		}
	}

}

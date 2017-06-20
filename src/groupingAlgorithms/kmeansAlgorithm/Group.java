package groupingAlgorithms.kmeansAlgorithm;

import java.util.ArrayList;
import java.util.List;
/**
 * This calss represents a group of values
 * @author helderjf
 *
 */
public class Group {
	private List<Value> values;
	private double currentCentroid;
	private double previousCentroid;

	/**
	 * Creates na new group
	 * @param centroid initial centroid
	 */
	public Group(double centroid) {
		this.values = new ArrayList<Value>();
		this.currentCentroid = centroid;
	}

	/**
	 * deletes all the group values
	 */
	public void clear() {
		this.values.clear();
	}

	/**
	 * Calculate the difference between a given value and the current centroid
	 * @param value value to calculate the difference
	 * @return the difference between the given value and the current centroid
	 */
	public double distanceToCentroid(int value) {
		return Math.abs(currentCentroid - value);
	}

	/**
	 * Adds a value to the group
	 * 
	 * @param value
	 *            value to add to the group
	 * @return true if the value is successfully added, false if not
	 */
	public boolean addValue(Value value) {
		return values.add(value);
	}

	/**
	 * Recalculate the group's centroid
	 * @return
	 */
	public double updateCentroid() {
		previousCentroid = currentCentroid;

		if (values.isEmpty()) {
			currentCentroid = 0;
			return currentCentroid;
		}

		int total = 0;
		for (Value value : values) {
			total += value.getValue();
		}

		currentCentroid = total / values.size();
		return currentCentroid;
	}

	/**
	 * Checks if the difference between the current centroid and the previous
	 * centroid is less or equal to a given margin of error
	 * 
	 * @param margin margin of error
	 * @return true if converged, false if not
	 */
	public boolean centroidsConverged(double margin) {
		if (Math.abs(currentCentroid - previousCentroid) <= margin) {
			return true;
		}
		return false;
	}


	/**
	 * converts the group Values to an array of int
	 * @return array of int
	 */
	public int[] getValuesArray() {
		int[] intValues = new int[values.size()];
		for(int i=0; i<values.size(); i++){
			intValues[i] = values.get(i).getValue();
		}
		return intValues;
	}

}

package groupingAlgorithms.biggestGapsAlgorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/**
 * Regresents a group of values
 * @author helderjf
 *
 */
public class Group {

	/**
	 * list of the group's values
	 */
	private List<Value> values;

	/**
	 * creates a new group
	 */
	public Group() {
		this.values = new ArrayList<Value>();
	}

	/**
	 * adds a new value to the group
	 * @param value value
	 * @return true if adding was successful, false if not
	 */
	public boolean addValue(Value value) {
		
		return values.add(value);
	}

	/**
	 * returns the list of values as an array of int 
	 * @return array of int
	 */
	public int[] getValuesArray() {

		int[] intValues = new int[values.size()];
		
		
		for (int i = 0; i < values.size(); i++) {
			intValues[i] = values.get(i).getValue();
		}
		return intValues;
	}

	/**
	 * Returns the group's values
	 * @return values
	 */
	public List<Value> getValues() {
		return values;
	}
	
	/**
	 * orders the group's values by their index in the original array
	 */
	public void orderByIndex(){
		Collections.sort(values, new ValueIndexComparator());
	}
	
	/**
	 * Cmparator for ordering the values by their index in the original array
	 * @author helderjf
	 *
	 */
	private class ValueIndexComparator implements Comparator<Value> {
		@Override
		public int compare(Value value1, Value value2) {
			return value1.getOriginalIndex() - value2.getOriginalIndex();
		}
	}


}

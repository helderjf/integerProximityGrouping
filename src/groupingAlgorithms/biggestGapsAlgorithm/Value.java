package groupingAlgorithms.biggestGapsAlgorithm;

/**
 * This class represents a value
 * 
 * @author helderjf
 *
 */
public class Value implements Comparable<Value> {
	/**
	 * numerical value
	 */
	private int value;

	/**
	 * index in the original array
	 */
	private int originalIndex;

	/**
	 * creates a new value
	 * @param value numerical value
	 * @param originalIndex index in the original array
	 */
	public Value(int value, int originalIndex) {
		this.value = value;
		this.originalIndex = originalIndex;
	}

	/**
	 * returns the numerical value
	 * @return value
	 */
	public int getValue() {
		return this.value;
	}

	/**
	 * returns index in the original array
	 * @return index in the original array
	 */
	public int getOriginalIndex() {
		return originalIndex;
	}


	@Override
	public int compareTo(Value otherValue) {
		return this.value - otherValue.value;
	}

}

package groupingAlgorithms.kmeansAlgorithm;
/**
 * This class represents a value
 * @author helderjf
 *
 */
public class Value {
	/**
	 * numerical value
	 */
	private int value;

	/**
	 * creates new value
	 * @param value numerical value
	 */
	public Value(int value) {
		this.value = value;
	}

	/**
	 * returns the numerical value
	 * @return numerical value
	 */
	public int getValue() {
		return this.value;
	}

}

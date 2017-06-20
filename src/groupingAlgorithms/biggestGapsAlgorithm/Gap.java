package groupingAlgorithms.biggestGapsAlgorithm;
/**
 * Represents a gap in the array of integers
 * @author helderjf
 *
 */
public class Gap implements Comparable<Gap> {

	/**
	 * size of the gap
	 */
	private int gapSize;
	
	/**
	 * index where the gap was found
	 */
	private int gapIndex;

	/**
	 * creates a new gap
	 * @param gapSize gap size
	 * @param gapIndex index where the gap was found
	 */
	public Gap(int gapSize, int gapIndex) {
		this.gapSize = gapSize;
		this.gapIndex = gapIndex;
	}

	/**
	 * Creates a new gap
	 * @param number1 first number
	 * @param number2 second number
	 * @param number1Index index of the first number
	 */
	public Gap(int number1, int number2, int number1Index) {
		this.gapSize = number2 - number1;
		this.gapIndex = number1Index;
	}

	@Override
	public int compareTo(Gap otherGap) {
		return this.gapSize - otherGap.gapSize;
	}

	@Override
	public String toString() {
		return "Gap [gapSize=" + gapSize + ", gapIndex=" + gapIndex + "]";
	}

	/**
	 *  Returns the gap index
	 * @return gap index
	 */
	public int getIndex() {
		return this.gapIndex;
	}

}


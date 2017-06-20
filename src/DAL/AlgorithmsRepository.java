package DAL;

import groupingAlgorithms.GroupingAlgorithm;
import java.util.HashMap;
import java.util.Map;

import groupingAlgorithms.biggestGapsAlgorithm.BiggestGaps;
import groupingAlgorithms.kmeansAlgorithm.KMeans;
/**
 * Provides a mock repository for the grouping algorithms 
 * @author helderjf
 *
 */
public class AlgorithmsRepository {

	/**
	 * Initializes and serves all the grouping algorithms available
	 * @return Grouping algorithms
	 */
	public Map<Integer, GroupingAlgorithm> getAlgorithms(){
		Map<Integer, GroupingAlgorithm> algorithms = new HashMap<Integer, GroupingAlgorithm>();
		
		algorithms.put(1, new KMeans());
		algorithms.put(2, new BiggestGaps());
		
		return algorithms;
	}
}

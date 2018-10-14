package problemSet_1;

import java.util.HashSet;
import java.util.Set;

public class KnapsackProblem01DP_2 {

	// Works only if contiguous elements needed to be picked. Not recommended to use.
	public static void main(String[] args) {
		int[] val = {60, 100, 120};
		int[] wt = {10, 20, 30};
		int W = 50;
		
		Set<Integer> selectedElements = new HashSet<Integer>();
		int maxValue = 0;
		
		for(int i = 0; i< val.length; i++){
			Set<Integer> selectedElementsInRow = new HashSet<Integer>();
			int maxValueInRow = 0;
			int remainingCapacity = W;
			for(int j = i; j< val.length; j++ ){
				if(remainingCapacity >= wt[j]){
					selectedElementsInRow.add(j);
					maxValueInRow = maxValueInRow + val[j];
					remainingCapacity = remainingCapacity - wt[j];
				}
			}
			if(maxValue < maxValueInRow){
				maxValue = maxValueInRow;
				selectedElements = selectedElementsInRow;
			}
		}
		
		System.out.println("Max Value : " + maxValue);
		System.out.println("Selected Elements at Index [starting with 0]: " + selectedElements);

	}

}

// Time Complexity - theta of n(n+1)/2 .. sum of AP
// O(n^2)
// Space Complexity - O(1)

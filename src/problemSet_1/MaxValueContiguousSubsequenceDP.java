package problemSet_1;

public class MaxValueContiguousSubsequenceDP {

	public static void main(String[] args) {
		int [] arr = {-5, -2, -8, -4, -3};
		//{-2, -3, 1, -1, 4, 0, 5, -2, 1};
		//{-2, 11, -4, 13, -5, 2};

		int max = Integer.MIN_VALUE/2;
		int previousValue = Integer.MIN_VALUE/2;
		int startIndex = -1;
		int endIndex = -1;
		for (int i = 0; i < arr.length; i++) {
			int currentValue;
			if (previousValue + arr[i] <= arr[i]) {
				startIndex = i;
				currentValue = arr[i];
			} else {
				currentValue = previousValue + arr[i];
			}

			if (max < currentValue){
				endIndex = i;
				max = currentValue;
			}
			if (startIndex > endIndex)
				startIndex = endIndex;

			previousValue = currentValue;
		}

		System.out.println("Index from " + startIndex + " to " + endIndex);
		System.out.println(" Max value : " + max);
	}

}

// Time complexity - O(n)
// Space - O(1)

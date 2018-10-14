package problemSet_1;

import java.util.Scanner;

public class FibonacciDP {

	public static void main(String[] args) {
		System.out.println("Enter number");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        // Bottom-up approach
		int lastNumber = 0;
		int secondLastNumber = 1;
		int result = n;
		for(int i = 2; i <= n; i++){
			result = lastNumber + secondLastNumber;
			lastNumber = secondLastNumber;
			secondLastNumber = result;
		}

		// Top-down approach
		//int result = fib(n, new int[n+1]);
		
		System.out.println("Fibonacci Value : " + result);
	}

	static int fib(int n, int[] resultArray) {
		if (n < 2)
			return n;
		if (resultArray[n] != 0)
			return resultArray[n];
		return resultArray[n] = fib(n-1, resultArray) + fib(n-2, resultArray);
	}
}

// Time Complexity = O(n)
// Space Complexity = O(1)

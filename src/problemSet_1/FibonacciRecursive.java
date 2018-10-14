package problemSet_1;

import java.util.Scanner;

public class FibonacciRecursive {
	
	private static int fib(int n){
		if(n <= 1)
			return n;
		else 
			return fib(n-1) + fib(n-2);

	}

	public static void main(String[] args) {
		System.out.println("Enter the nth number for fab series, counting starts with 0 ");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println("Fib value is :- " + fib(n));
		

	}

}

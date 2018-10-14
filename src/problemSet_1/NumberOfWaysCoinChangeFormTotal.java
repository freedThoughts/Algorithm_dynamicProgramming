package problemSet_1;

import java.util.Scanner;

//https://www.geeksforgeeks.org/dynamic-programming-set-7-coin-change/
public class NumberOfWaysCoinChangeFormTotal {

    public static void main(String[] a){
        Scanner in = new Scanner(System.in);
        int testCases = Integer.valueOf(in.nextLine());
        int[] answers = new int[testCases];
        for(int test = 0; test < testCases; test++){
            int sizeOfArray = Integer.valueOf(in.nextLine());
            String[] s = in.nextLine().split(" ");
            int[] coins = new int[sizeOfArray];
            for(int i = 0; i < sizeOfArray; i++)
                coins[i] = Integer.valueOf(s[i]);

            int total = Integer.valueOf(in.nextLine());
            answers[test] = getNumberOfChangePossible(coins, total);
        }

        for(int i : answers)
            System.out.println(i);
    }

    private static int getNumberOfChangePossible(int[] coins, int total) {

        // We can use 1D array as we have infinite supply of each denomination of coins.
        // We can use same denomination coins multiple times.
        int[] capacities = new int[total +1];
        capacities[0] = 1;

        for(int indexOfCoin = 0; indexOfCoin < coins.length; indexOfCoin++){
            for(int currentCapacity = coins[indexOfCoin]; currentCapacity < capacities.length; currentCapacity++ ){
                capacities[currentCapacity] += capacities[currentCapacity - coins[indexOfCoin]];
            }
        }
        return capacities[total];
    }
}

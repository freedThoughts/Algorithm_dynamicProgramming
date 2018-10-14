package problemSet_1;

import java.util.Scanner;

// https://practice.geeksforgeeks.org/problems/kadanes-algorithm/0
// Given an array containing both negative and positive integers. Find the contiguous sub-array with maximum sum.
public class KadanesAlgorithm {
    public static void main(String[] a){
        Scanner in = new Scanner(System.in);
        int testCases = Integer.valueOf(in.nextLine());
        int[] answers = new int[testCases];
        for(int test = 0; test < testCases; test++){
            int sizeOfArray = Integer.valueOf(in.nextLine());
            String[] s = in.nextLine().split(" ");
            int[] arr = new int[sizeOfArray];
            for(int i = 0; i < sizeOfArray; i++)
                arr[i] = Integer.valueOf(s[i]);

            answers[test] = getContiguousSubArrayWithMaximumSum(arr);
        }

        for(int i : answers)
            System.out.println(i);
    }

    private static int getContiguousSubArrayWithMaximumSum(int[] arr){
        int startIndexForSubArray = -1;
        int endIndexForSubArray = -1;
        int resultSum = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++){
            int currentSum = 0;
            for(int j = i; j < arr.length; j++){
                currentSum += arr[j];
                if(currentSum > resultSum){
                    resultSum = currentSum;
                    startIndexForSubArray = i;
                    endIndexForSubArray = j;
                }
            }
        }

        System.out.println("Start Index : - " + startIndexForSubArray + " and EndIndex : " + endIndexForSubArray);
        return resultSum;
    }
}

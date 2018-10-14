package problemSet_1;

import java.util.Scanner;

public class MinimumNumberOfJumps {

    public static void main(String[] a){
        Scanner in = new Scanner(System.in);
        int testCases = Integer.valueOf(in.nextLine().split(" ")[0]);
        int[] answers = new int[testCases];
        for(int test = 0; test < testCases; test++){
            int noOfElements = Integer.valueOf(in.nextLine().split(" ")[0]);
            String[] s = in.nextLine().split(" ");
            int[] arr = new int[noOfElements];
            for(int i = 0; i < noOfElements; i++){
                arr[i] = Integer.valueOf(s[i]);
            }
            int[] noOfJump = new int[noOfElements];
            for(int i = 1; i < noOfElements; i++)
                noOfJump[i] = Integer.MAX_VALUE -100;
            noOfJump[0] = 0;
            int[] jumpThroughIndex = new int[noOfElements];

            for(int i = 1; i < noOfElements; i++){
                for(int j = 0; j < arr.length && j < arr[i]; j++){
                    if(arr[j] >= (i-j) && (noOfJump[j] +1) < noOfJump[i]) {
                        noOfJump[i] = noOfJump[j] +1;
                        jumpThroughIndex[i] = j;
                    }
                }
            }
            answers[test] = noOfJump[noOfElements-1];
        }
        for(int i = 0; i < testCases; i++)
            System.out.println(answers[i] + " ");
    }
}

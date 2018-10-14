package problemSet_1;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

// We will have a matrix item vs capacity
public class KnapsackProblem01_DP {

    private static int getMaxValue(int totalWeight, int[] weight, int[] value){

        int[][] matrix = new int[value.length +1][totalWeight +1];

        for(int itemNumber = 0; itemNumber < matrix.length; itemNumber++){
            for(int weightCapacity = 0; weightCapacity < totalWeight +1; weightCapacity ++){
                if(itemNumber == 0 || weightCapacity == 0){
                    matrix[itemNumber][weightCapacity] = 0;
                    continue;
                }

                if(weight[itemNumber -1] <= weightCapacity){
                    matrix[itemNumber][weightCapacity] = Math.max(value[itemNumber-1] + matrix[itemNumber-1][weightCapacity - weight[itemNumber -1]],
                            matrix[itemNumber-1][weightCapacity]);
                    continue;
                }

                matrix[itemNumber][weightCapacity] = matrix[itemNumber-1][weightCapacity];
            }
        }

        // Get the items selected
        Set<Integer> indexesOfItemsPicked = getItemsPicked(matrix, totalWeight, weight);
        for(Integer itemIndex : indexesOfItemsPicked)
            System.out.print(itemIndex + " ");
        System.out.println();

        return matrix[value.length][totalWeight];
    }

    private static Set<Integer> getItemsPicked(int[][] matrix, int totalWeight, int[] weight){
        int rowIndex = weight.length;
        int columnIndex = totalWeight;
        Set<Integer> indexesOfItemPicked = new HashSet<>();

        while(rowIndex > 0 && columnIndex > 0){
            if(matrix[rowIndex][columnIndex] == matrix[rowIndex -1][columnIndex]){
                rowIndex--;
                continue;
            }

            indexesOfItemPicked.add(rowIndex -1);
            columnIndex -= weight[rowIndex -1];
            rowIndex--;

        }
        return indexesOfItemPicked;
    }

    public static void main(String[] a){
        Scanner in = new Scanner(System.in);
        int testCases = Integer.valueOf(in.nextLine());
        int[] answers = new int[testCases];
        for(int t = 0; t < testCases; t++){
            int numberOfItems = Integer.valueOf(in.nextLine());
            int maxCapacity = Integer.valueOf(in.nextLine());
            String[] s = in.nextLine().split(" ");
            int[] values = new int[numberOfItems];
            for(int itemNumber = 0; itemNumber< numberOfItems; itemNumber ++)
                values[itemNumber] = Integer.valueOf(s[itemNumber]);

            s = in.nextLine().split(" ");
            int[] weight = new int[numberOfItems];
            for(int itemNumber = 0; itemNumber < numberOfItems; itemNumber ++)
                weight[itemNumber] = Integer.valueOf(s[itemNumber]);

            answers[t] = getMaxValue(maxCapacity, weight, values);
        }
        for(int answer : answers)
            System.out.println(answer);
    }
}


// Time complexity - O( item * capacity)
// Space complexity - O(item * capacity)
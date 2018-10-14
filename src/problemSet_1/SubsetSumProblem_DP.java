package problemSet_1;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Prakash on 25-05-2018.
 */
public class SubsetSumProblem_DP {

    private static boolean isSubSetPossible(int capacity, int[] items){
        int[][] matrix = new int[items.length +1][capacity +1];
        for(int row = 0; row < items.length +1; row ++){
            for(int column = 0; column < capacity +1; column ++){
                if(row == 0 || column == 0){
                    matrix[row][column] = 0;
                    continue;
                }

                if(items[row -1] > column){
                    matrix[row][column] = matrix[row-1][column];
                    continue;
                }

                matrix[row][column] = Math.max(items[row-1] + matrix[row-1][column - items[row-1]], matrix[row-1][column]);
            }
        }

        // Get the sets selected
        Set<Set<Integer>> sets = new HashSet<>();
        getSets(matrix, items.length, capacity, capacity, new HashSet<Integer>(), sets, items);
        printSets(sets);

        return matrix[items.length][capacity] == capacity;
    }

    private static void getSets(int[][] matrix, int row, int column, int sum, Set<Integer> innerSet, Set<Set<Integer>> outerSet, int[] items){
        if(sum == 0){
            outerSet.add(innerSet);
            return;
        }

        if(row <= 0 || column <= 0)
            return;

        // If one row higher. also have same value in matrix. We can form a set with either current item or one row higher item
        if(matrix[row][column] == matrix[row-1][column]){
            Set<Integer> inn = new HashSet<>();
            inn.addAll(innerSet);
            getSets(matrix, row-1, column, sum, inn, outerSet, items);
        }

        sum -= items[row -1];
        innerSet.add(items[row-1]);
        column -= items[row-1];
        row--;

        getSets(matrix, row, column, sum, innerSet, outerSet, items);
    }

    private static void printSets(Set<Set<Integer>> s){
        for(Set<Integer> k : s){
            for(Integer m : k)
                System.out.print(m + " ");
            System.out.println();
        }
    }

    public static void main(String[] a){
        int capacity = 10;
        int[] items = {1, 2, 3,4, 5 };

        System.out.println("With given items, sum can be formed :- " + isSubSetPossible(capacity, items));
    }


}

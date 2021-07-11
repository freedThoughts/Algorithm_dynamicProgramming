package problemSet_1;

public class OptimalBinarySearchTree {

    public static void main(String[] a){
        int[] key = {10, 12, 16, 21};
        int[] frequency = {4, 2, 6, 3};
        System.out.println(getMinSearchCost(key, frequency));
    }

    private static int getMinSearchCost(int[] key, int[] frequency) {
        int[][] matrix = new int[key.length][key.length];

        for (int startPoint = 0; startPoint < key.length; startPoint++) {  // O(n)
            for (int i = 0, j = startPoint; i < key.length && j < key.length; i++, j++) {    // O(n^2)
                if (i == j) {
                    matrix[i][j] = frequency[i];
                } else {
                    int totalSum = 0;
                    int minValue = Integer.MAX_VALUE;

                    for (int root = i; root <= j; root++) {                // O(n^3)
                        totalSum += frequency[root];

                        int additionalLevelValue = 0;

                        if (root == i) {
                            additionalLevelValue = matrix[root+1][j];
                        } else if (root == j) {
                            additionalLevelValue = matrix[i][root-1];
                        } else {
                            additionalLevelValue = matrix[i][root-1] + matrix[root+1][j];
                        }
                        minValue = Math.min(minValue, additionalLevelValue);
                    }
                    matrix[i][j] = totalSum + minValue;
                }
            }
        }

        return matrix[0][key.length-1];
    }
}

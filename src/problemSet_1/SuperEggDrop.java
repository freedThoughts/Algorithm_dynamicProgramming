package problemSet_1;
// https://leetcode.com/problems/super-egg-drop/submissions/
public class SuperEggDrop {
    public int superEggDrop(int k, int n) {

        int[][] matrix = new int[k][n+1];
        for(int j = 0; j < matrix[0].length; j++ )
            matrix[0][j] = j;

        for(int i = 1; i < k; i++) {
            for(int j = 1; j < matrix[0].length; j++) {
                int min = matrix[i-1][j];
                for(int m = 1; m <= j; m++)
                    min = Math.min(min, 1+ Math.max(matrix[i-1][m-1], matrix[i][j-m]));
                matrix[i][j] = min;
            }
        }
        return matrix[matrix.length-1][matrix[0].length-1];
    }
}


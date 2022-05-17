package problemSet_1;

// https://leetcode.com/problems/unique-paths-ii/submissions/
public class UniquePathsii {
    public static void main(String[] arg) {
        System.out.println(uniquePathsWithObstacles(new int[][]{{0,0,0},{0,1,0},{0,0,0}}));

    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] matrix = new int[m][n];

        for(int i = m-1; i>= 0; i--) {
            for (int j = n-1; j >= 0 ; j--) {
                if (obstacleGrid[i][j] == 1) {
                    matrix[i][j] = 0;
                    continue;
                }
                if (i == m-1 && j == n-1){
                    matrix[i][j] = 1;
                    continue;
                }
                int rightVal = j == n-1 ? 0 : matrix[i][j+1];
                int downVal = i == m-1 ? 0 : matrix[i+1][j];
                matrix[i][j] = rightVal + downVal;
            }
        }

        return matrix[0][0];
    }
}

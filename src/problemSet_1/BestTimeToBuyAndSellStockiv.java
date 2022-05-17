package problemSet_1;
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/submissions/
public class BestTimeToBuyAndSellStockiv {

    public int maxProfit2(int k, int[] prices) {
        if (prices.length == 0) return 0;
        int[][] matrix = new int[k+1][prices.length];
        for(int i = 1; i < matrix.length; i++) {
            int temp = Integer.MIN_VALUE;
            for(int j = 1; j < matrix[0].length; j++) {
                int val = Math.max(matrix[i][j-1], matrix[i-1][j]);
                temp = Math.max(temp,  matrix[i-1][j-1] - prices[j-1]);
                matrix[i][j] = Math.max(val, prices[j] + temp);
            }
        }
        return matrix[matrix.length-1][matrix[0].length-1];
    }

    public int maxProfit(int k, int[] prices) {
        if (prices.length == 0) return 0;
        int[][] matrix = new int[k+1][prices.length];
        for(int i = 1; i < matrix.length; i++) {
            for(int j = 1; j < matrix[0].length; j++) {
                int val = Math.max(matrix[i][j-1], matrix[i-1][j]);
                int temp = val;
                for(int m = 0; m < j ; m++) {
                    temp = Math.max(temp, prices[j] - prices[m] + matrix[i-1][m]);
                }
                matrix[i][j] = Math.max(val, temp);
            }
        }
        return matrix[matrix.length-1][matrix[0].length-1];
    }
}

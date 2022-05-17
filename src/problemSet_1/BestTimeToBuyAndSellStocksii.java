package problemSet_1;

import java.util.List;
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/submissions/
public class BestTimeToBuyAndSellStocksii {

    public int maxProfit(int[] prices){
        int profit = 0;
        for(int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i-1])
                profit = profit + prices[i] - prices[i-1];
        }
        return profit;
    }

    public int maxProfit44(int[] prices) {
        int[] arr = new int[prices.length];

        for(int i = 1; i < prices.length; i++) {
            for(int j = 0; j < i; j++) {
                arr[i] = Math.max(arr[i], prices[i] - prices[j] + arr[j]);
            }
            arr[i] = Math.max(arr[i], arr[i-1]);
        }

        return arr[arr.length-1];
    }
}

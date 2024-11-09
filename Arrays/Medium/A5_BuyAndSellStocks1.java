package Arrays.Medium;

public class A5_BuyAndSellStocks1 {
    public static void main(String[] args) {
        Solution_A5 sol = new Solution_A5();

        int[] arr = {7,1,5,3,6,4};
        int maxProfit = sol.maxProfit(arr);
        System.out.printf("max profit: %d", maxProfit);
    }
}


class Solution_A5 {
    public int maxProfit(int[] prices) {
        int min = prices[0], maxProfit = 0;

        for(int i = 1; i < prices.length; i++){
            maxProfit = Math.max(maxProfit, prices[i] - min);
            min = Math.min(min, prices[i]);
        }

        return maxProfit;
    }
}

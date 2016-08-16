/*

Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

*/

public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        
        int[] f = new int[prices.length];
        int lowest = prices[0];
        f[0] = 0;
        
        for (int i = 1; i < prices.length; i++) {
            // Record the lowest price before current day (including current day)
            lowest = Math.min(lowest, prices[i]);
            f[i] = Math.max(f[i - 1], prices[i] - lowest);
        }
        
        return f[prices.length - 1];
    }
}
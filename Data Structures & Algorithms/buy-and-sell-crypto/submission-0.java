class Solution {
        public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int n = prices.length;
        int left = 0;
        int right = 1;
        while (right < n) {
            int profit = prices[right] - prices[left];
            if (profit < 0) {
                left = right;
            } else {
                maxProfit = Math.max(maxProfit, profit);
            }
            right++;
        }
        return maxProfit;
    }
}
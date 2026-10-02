class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length < 2){
            return 0;
        }
        int maxProfit = 0;
        int buyPrice = prices[0];
        for(int i=1; i< prices.length; i++){
            maxProfit = Math.max(maxProfit, prices[i] - buyPrice);
            buyPrice = Math.min(buyPrice, prices[i]);
        }
        return maxProfit;

    }

    /*public int maxProfit(int[] prices) {
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
    }*/
}
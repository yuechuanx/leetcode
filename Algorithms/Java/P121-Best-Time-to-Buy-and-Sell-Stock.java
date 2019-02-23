class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 0 || prices.length == 1) return 0;
        
        int n = prices.length;
        int min, max, res, curr;
        min = max = prices[0];
        res = curr = 0;
        
        for (int i = 1; i < n; ++i) {
            if (min > prices[i]) {
                min = prices[i];
                max = min;
            } else {
                max = (max < prices[i]) ? prices[i] : max;
                curr = max - min;
                res = (res < curr) ? curr : res;
            }
        }
        
        return res;
    }
}
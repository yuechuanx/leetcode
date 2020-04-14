/* best solution */
class Solution {
    public int maxProfit(int[] prices) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        
        for (int price : prices) {
            if (price < minprice) {
                minprice = price;
            } else {
                maxprofit = Math.max(maxprofit, price - minprice);
            }
        }
        
        return maxprofit;
    }
}

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

/**
 * brute-force
 * 这代码写得真烂
 */
class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0 || prices.length == 1) {
            return 0;
        }
        
        int[] profit = new int[prices.length];
        
        for (int i = 0; i < prices.length; ++i) {
            for (int j = i + 1; j < prices.length; ++j) {
                    profit[i] = Math.max(profit[i], prices[j] - prices[i]);
            }
        }

        int res = -1;
        for (int p : profit) {
            res = Math.max(res, p);
        }
        
        return res;
    }
}

public class Solution {
    public int maxProfit(int prices[]) {
        int maxprofit = 0;

        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                if (profit > maxprofit)
                    maxprofit = profit;
            }
        }
        
        return maxprofit;
    }
}


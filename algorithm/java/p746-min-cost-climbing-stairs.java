class Solution {
    public int minCostClimbingStairs(int[] cost) {
        if (cost.length == 2) {
            return Math.min(cost[0], cost[1]);
        }

        int n = cost.length;
        int[] dp = new int[n];
        dp[0] = cost[0];
        dp[1] = cost[1];        
        
        /* 递推公式 dp[i] = min{dp[i - 1], dp[i -2] + cost[i]} */
        for (int i = 2; i < n; ++i) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        }
        
        return Math.min(dp[n - 1], dp[n - 2]);
    }
}
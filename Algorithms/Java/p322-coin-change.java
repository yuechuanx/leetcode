class Solution {
    public int coinChange(int[] coins, int amount) {
        // check input is valid 
        if (coins == null || coins.length == 0 || amount < 0) {
            return -1;
        }
        int N = coins.length;
        int max = Integer.MAX_VALUE;
        // build dp table and initialize
        int[][] dp = new int[N][amount + 1]; // dp[i][j] means min number use coins[0...i] to reprent j 
        for (int j = 1; j <= amount; j++) {
            dp[0][j] = max; 
            if (j - coins[0] >= 0 && dp[0][j - coins[0]] != max) {  // 面额比兑换值小，且减去该面额能够兑换
                dp[0][j] = dp[0][j - coins[0]] + 1;
            }
        }
        
        int left = 0;
        for (int i = 1; i < N; ++i) {
            for (int j = 1; j <= amount; ++j) {
                left = max;
                if (j - coins[i] >= 0 && dp[i][j - coins[i]] != max) {
                    left = dp[i][j - coins[i]] + 1;
                }
                dp[i][j] = Math.min(left, dp[i - 1][j]);
            }
        } 
        
        return dp[N - 1][amount] != max ? dp[N - 1][amount] : -1;
    }
}


class Solution {
    public int coinChange(int[] coins, int amount) {
        // check input 
        if (coins == null || coins.length == 0 || amount < 0) {
            return -1;
        }
        // initialize dp table
        int n = coins.length;
        int[] dp = new int[amount + 1];
        for (int j = 1; j <= amount; ++j) {
            dp[j] = Integer.MAX_VALUE;
            if (j - coins[0] >= 0 && dp[j - coins[0]] != Integer.MAX_VALUE) { // 面额不超过找零且减去当前面额能够找零
                dp[j] = dp[j - coins[0]] + 1;
            }
        }
        // update dp table
        int left = 0;
        for (int i = 1; i < n; ++i) {
            for (int j = 1; j <= amount; ++j) {
                left = Integer.MAX_VALUE;
                if (j - coins[i] >= 0 && dp[j - coins[i]] != Integer.MAX_VALUE) {
                    left = dp[j - coins[i]] + 1;
                }
                dp[j] = Math.min(left, dp[j]);
            }
        }
        
        return dp[amount] != Integer.MAX_VALUE ? dp[amount] : -1;
    }
}
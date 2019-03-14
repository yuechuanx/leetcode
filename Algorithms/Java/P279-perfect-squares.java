/*
 * @lc app=leetcode id=279 lang=java
 *
 * [279] Perfect Squares
 *
 * https://leetcode.com/problems/perfect-squares/description/
 *
 * algorithms
 * Medium (40.89%)
 * Total Accepted:    165.3K
 * Total Submissions: 403.2K
 * Testcase Example:  '12'
 *
 * Given a positive integer n, find the least number of perfect square numbers
 * (for example, 1, 4, 9, 16, ...) which sum to n.
 * 
 * Example 1:
 * 
 * 
 * Input: n = 12
 * Output: 3 
 * Explanation: 12 = 4 + 4 + 4.
 * 
 * Example 2:
 * 
 * 
 * Input: n = 13
 * Output: 2
 * Explanation: 13 = 4 + 9.
 */
class Solution {
    public int numSquares(int n) {
        int maxSquare = (int) Math.sqrt(n);
        int[][] dp = new int[maxSquare + 1][n + 1];
        for (int j = 1; j <= n; ++j) {
            dp[1][j] = j;
        }

        for (int i = 1; i <= maxSquare; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (j - i * i < 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Integer.MAX_VALUE;
                    int k = i;
                    while (k >= 0) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][j - k * k]);
                    }
                }
            }
        }

        return dp[maxSquare][n];
    }
}


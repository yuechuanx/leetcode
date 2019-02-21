class Solution {
    public boolean stoneGame(int[] piles) {
        int N = piles.length;
        // dp[i][j] means remain piles[i...j]
        // dp[:][0] & dp[0][:] position will not be operated
        int[][] dp = new int[N + 2][N + 2];
        for (int size = 1; size <= N; ++size) {
            for (int l = 0; l + size <= N; ++l) {
                int r = l + size - 1;
                int parity = (l + r + N) % 2;
                if (parity == 1) {
                    // 
                    dp[l+1][r+1] = Math.max(piles[l] + dp[l+2][r+1], piles[r] + dp[l+1][r]);
                } else {
                    dp[l+1][r+1] = Math.min(-piles[l] + dp[l+2][r+1], -piles[r] + dp[l+1][r]);
                }
            }
        }
        
        return dp[1][N] > 0; // dp[1][N] = piles[1...N] 
    }
}
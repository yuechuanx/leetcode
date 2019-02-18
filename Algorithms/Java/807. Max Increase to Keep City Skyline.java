class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int N = grid.length;
        int[] rowMaxes = new int[N];
        int[] colMaxes = new int[N];
        
        for (int row = 0; row < N; ++row) {
            for (int col = 0; col < N; ++col) {
                rowMaxes[row] = Math.max(rowMaxes[row], grid[row][col]);
                colMaxes[col] = Math.max(colMaxes[col], grid[row][col]);
            }
        }
            
        int res = 0;
        for (int r = 0; r < N; ++r)
            for (int c =0; c < N; ++c)
                res +=Math.min(rowMaxes[r], colMaxes[c]) - grid[r][c];
        
        return res;
    }
}
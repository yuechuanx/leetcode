// backtrack
class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 1) {
            return grid.length == 1 ? grid[0][0] : 0;
        }
        int[][] memo = new int[grid.length][grid[0].length];
        return backtrack(grid, 0, 0, memo);
        
    }
    
    private int backtrack(int[][] grid, int i, int j, int[][] memo) {
        // how about this if do ?
        if (memo[i][j] != 0) 
            return memo[i][j];
        // recursion return
        if (i == grid.length - 1 && j == grid[0].length - 1)
            return grid[i][j];
        
        int min = Integer.MAX_VALUE;
        if (j < grid.length - 1) 
            min = Math.min(backtrack(grid, i + 1, j, memo), min);
        if (i < grid[0].length - 1) 
            min = Math.min(backtrack(grid, i, j + 1, memo), min);
        
        min += grid[i][j];
        memo[i][j] = min;
        
        return min;
    }
}

// dynamic programming
public int minPathSum(int[][] grid) {
	int m = grid.length;// row
	int n = grid[0].length; // column
	for (int i = 0; i < m; i++) {
		for (int j = 0; j < n; j++) {
			if (i == 0 && j != 0) {
				grid[i][j] = grid[i][j] + grid[i][j - 1];
			} else if (i != 0 && j == 0) {
				grid[i][j] = grid[i][j] + grid[i - 1][j];
			} else if (i == 0 && j == 0) {
				grid[i][j] = grid[i][j];
			} else {
				grid[i][j] = Math.min(grid[i][j - 1], grid[i - 1][j])
						+ grid[i][j];
			}
		}
	}

	return grid[m - 1][n - 1];
}
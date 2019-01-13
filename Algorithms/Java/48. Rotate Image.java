class Solution {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 1) 
            return;
        
        int n = matrix.length;
        
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        
        if (n % 2 == 0) {
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n/2; ++j) {
                    int tmp = matrix[i][j];
                    matrix[i][j] = matrix[i][n-j-1];
                    matrix[i][n-j-1] = tmp;
                }
            }
        } else {
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n / 2; ++j) {
                    int tmp = matrix[i][j];
                    matrix[i][j] = matrix[i][n-j-1];
                    matrix[i][n-j-1] = tmp;
                }
            }
        }

    }
}
class NumMatrix {
    private int[][] dp;

    public NumMatrix(int[][] matrix) {
        int rows = matrix.length;
        if (rows == 0) return;
        int cols = matrix[0].length;
        dp = new int[rows + 1][cols + 1];

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                dp[i][j] = matrix[i-1][j-1] +
                             dp[i-1][j] +
                             dp[i][j-1] -
                             dp[i-1][j-1];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return dp[row2+1][col2+1] -
               dp[row1][col2+1] -
               dp[row2+1][col1] +
               dp[row1][col1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
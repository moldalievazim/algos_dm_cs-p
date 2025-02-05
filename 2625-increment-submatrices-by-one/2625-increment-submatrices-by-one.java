class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] diff = new int[n + 1][n + 1];
        
        for (int[] q : queries) {
            int r1 = q[0], c1 = q[1], r2 = q[2], c2 = q[3];
            diff[r1][c1] += 1;
            diff[r1][c2 + 1] -= 1;
            diff[r2 + 1][c1] -= 1;
            diff[r2 + 1][c2 + 1] += 1;
        }
        
        // Compute row-wise prefix sums
        for (int i = 0; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                diff[i][j] += diff[i][j - 1];
            }
        }
        
        // Compute column-wise prefix sums
        for (int j = 0; j <= n; j++) {
            for (int i = 1; i <= n; i++) {
                diff[i][j] += diff[i - 1][j];
            }
        }
        
        // Extract the original matrix (first n rows and columns)
        int[][] mat = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = diff[i][j];
            }
        }
        
        return mat;
    }
}
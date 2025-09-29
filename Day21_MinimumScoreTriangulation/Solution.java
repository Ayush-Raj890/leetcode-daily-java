package Day21_MinimumScoreTriangulation;

class Solution {
    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n - 1; ++i) {
            dp[i][i + 1] = 0; // No triangle can be formed with less than 3 points
        }
        for (int i = n - 1; i >= 0; --i) {
            for (int j = i + 2; j < n; ++j) { // j must be at least i+2 to form a triangle
                dp[i][j] = Integer.MAX_VALUE; // Initialize before k-loop
                for (int k = i + 1; k < j; ++k) {
                    dp[i][j] = Math.min(dp[i][j],
                        dp[i][k] + values[i] * values[k] * values[j] + dp[k][j]);
                }
            }
        }
        return dp[0][n - 1];
    }
}
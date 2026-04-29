# 3225. Maximum Score From Grid Operations

## Approach
- Build prefix sums for every column so any vertical segment sum can be read in constant time.
- Process the grid one column pair at a time and keep dynamic programming states indexed by the two boundary rows used so far.
- For each transition, use auxiliary prefix/suffix maximum tables to avoid scanning all previous states repeatedly.
- The DP stores the best score after finishing each column boundary, then rolls forward to the next column.

## Java Solution
```java
class Solution {
    public long maximumScore(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;
        if (m == 1) return 0;

        long[][] col = new long[m][n + 1];

        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                col[j][i + 1] = col[j][i] + grid[i][j];
            }
        }

        long[][] dp = new long[n + 1][n + 1];
        long[][] prefMax = new long[n + 1][n + 1];
        long[][] suffMax = new long[n + 1][n + 1];

        for (int c = 1; c < m; c++) {

            long[][] newdp = new long[n + 1][n + 1];

            for (int curr = 0; curr <= n; curr++) {
                for (int prev = 0; prev <= n; prev++) {

                    if (curr <= prev) {
                        long gain = col[c][prev] - col[c][curr];

                        newdp[curr][prev] = Math.max(
                                newdp[curr][prev],
                                suffMax[prev][0] + gain
                        );
                    } else {
                        long gain = col[c - 1][curr] - col[c - 1][prev];

                        newdp[curr][prev] = Math.max(
                                newdp[curr][prev],
                                Math.max(
                                        suffMax[prev][curr],
                                        prefMax[prev][curr] + gain
                                )
                        );
                    }
                }
            }

            for (int curr = 0; curr <= n; curr++) {

                prefMax[curr][0] = newdp[curr][0];

                for (int prev = 1; prev <= n; prev++) {

                    long penalty = 0;
                    if (prev > curr)
                        penalty = col[c][prev] - col[c][curr];

                    prefMax[curr][prev] = Math.max(
                            prefMax[curr][prev - 1],
                            newdp[curr][prev] - penalty
                    );
                }

                suffMax[curr][n] = newdp[curr][n];

                for (int prev = n - 1; prev >= 0; prev--) {
                    suffMax[curr][prev] = Math.max(
                            suffMax[curr][prev + 1],
                            newdp[curr][prev]
                    );
                }
            }

            dp = newdp;
        }

        long ans = 0;
        for (int k = 0; k <= n; k++) {
            ans = Math.max(ans, Math.max(dp[0][k], dp[n][k]));
        }

        return ans;
    }
}
```

## Complexity
- Time: `O(m * n^2)`.
- Space: `O(n^2)`.
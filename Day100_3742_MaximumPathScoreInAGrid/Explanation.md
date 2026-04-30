# 3742. Maximum Path Score in a Grid

## Approach
- Use dynamic programming over the grid with a third dimension for how many non-zero cells have been used so far.
- `dp[i][j][c]` stores the best score reaching cell `(i, j)` after spending exactly `c` cost.
- From each state, try moving down or right.
- Moving onto a non-zero cell increases the cost by `1`, while moving onto `0` keeps the cost unchanged.
- Initialize the start cell with score `0` and take the best value at the bottom-right across all valid costs.

## Java Solution
```java
import java.util.Arrays;

class Solution {
    public int maxPathScore(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        int[][][] dp = new int[m][n][k + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], Integer.MIN_VALUE);
            }
        }

        dp[0][0][0] = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int c = 0; c <= k; c++) {
                    if (dp[i][j][c] == Integer.MIN_VALUE) continue;

                    if (i + 1 < m) {
                        int val = grid[i + 1][j];
                        int cost = (val == 0 ? 0 : 1);
                        if (c + cost <= k) {
                            dp[i + 1][j][c + cost] = Math.max(
                                dp[i + 1][j][c + cost],
                                dp[i][j][c] + val
                            );
                        }
                    }

                    if (j + 1 < n) {
                        int val = grid[i][j + 1];
                        int cost = (val == 0 ? 0 : 1);
                        if (c + cost <= k) {
                            dp[i][j + 1][c + cost] = Math.max(
                                dp[i][j + 1][c + cost],
                                dp[i][j][c] + val
                            );
                        }
                    }
                }
            }
        }

        int ans = Integer.MIN_VALUE;
        for (int c = 0; c <= k; c++) {
            ans = Math.max(ans, dp[m - 1][n - 1][c]);
        }

        return ans < 0 ? -1 : ans;
    }
}
```

## Complexity
- Time: `O(m * n * k)`.
- Space: `O(m * n * k)`.
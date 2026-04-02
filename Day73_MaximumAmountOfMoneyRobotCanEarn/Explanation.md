# 3418. Maximum Amount of Money Robot Can Earn

## Summary
The robot moves from the top-left to the bottom-right of the grid, only moving right or down. Positive cells add money, negative cells subtract money, and the robot can neutralize at most 2 negative cells on its path so those cells do not reduce the total.

## Approach
Use dynamic programming with a 3D state.

Let `dp[i][j][k]` be the maximum money the robot can have when it reaches cell `(i, j)` after using exactly `k` neutralizations, where `k` is in the range `0..2`.

For each cell, there are two ways to arrive:
1. From the top cell `(i - 1, j)`.
2. From the left cell `(i, j - 1)`.

If the current cell value is non-negative, the robot always adds it to the total.

If the current cell value is negative, there are two choices:
1. Take the loss and keep the same number of neutralizations used.
2. Neutralize the robber, which increases the used neutralizations by 1 and adds nothing to the total.

The transitions are:
- `dp[i][j][k] = max(dp[i - 1][j][k], dp[i][j - 1][k]) + coins[i][j]` when the cell is not neutralized.
- `dp[i][j][k] = max(dp[i - 1][j][k - 1], dp[i][j - 1][k - 1])` when the current negative cell is neutralized.

The base cell `(0, 0)` is initialized for all valid neutralization counts, including the case where the starting cell is negative and gets neutralized.

The answer is the maximum value among `dp[n - 1][m - 1][0]`, `dp[n - 1][m - 1][1]`, and `dp[n - 1][m - 1][2]`.

## Complexity
- Time: `O(m * n * 3)`
- Space: `O(m * n * 3)`

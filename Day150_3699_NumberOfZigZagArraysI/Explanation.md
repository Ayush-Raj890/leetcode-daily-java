# Day 150 - 3699. Number of ZigZag Arrays I

## Problem
Count the number of zigzag arrays of length `n` with values in the range `[l, r]`.

## Approach
Use a one-dimensional DP over the available value range. The array `dp[j]` tracks the number of valid sequences ending at the `j`-th value in the range. For each new position, the update direction alternates: one pass scans left-to-right and the next scans right-to-left, building prefix-style sums in `O(m)` per layer where `m = r - l + 1`.

## Complexity
- Time: `O(nm)`
- Space: `O(m)`

## Code Reference
See [Solution.java](Solution.java) for the implementation.
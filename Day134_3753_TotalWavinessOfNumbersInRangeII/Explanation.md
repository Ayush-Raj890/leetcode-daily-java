# Day 134 - 3753. Total Waviness of Numbers in Range II

## Problem
Count the total waviness of numbers in the inclusive range `[A, B]`.

## Approach
Precompute all 3-digit patterns whose middle digit is strictly greater than both neighbors or strictly smaller than both neighbors. Then count how many valid numbers of each pattern appear up to a given bound using digit-position counting, and subtract prefix counts to get the answer for `[A, B]`.

## Complexity
- Time: `O(1)` relative to input size, because the pattern set is fixed
- Space: `O(1)`

## Code Reference
See [Solution.java](Solution.java) for the implementation.
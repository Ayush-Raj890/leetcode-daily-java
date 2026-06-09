# Day 138 - 3689. Maximum Total Subarray Value I

## Problem
Find the maximum total value of a subarray after applying the given multiplier.

## Approach
The result depends only on the smallest and largest values in the array. Scan the array once to track the minimum and maximum elements, then compute the answer as the difference between them multiplied by `k`.

## Complexity
- Time: `O(n)`
- Space: `O(1)`

## Code Reference
See [Solution.java](Solution.java) for the implementation.
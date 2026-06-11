# Day 140 - 3558. Number of Ways to Assign Edge Weights I

## Problem
Count the number of valid edge-weight assignments on a tree.

## Approach
Root the tree at node `1` and compute the maximum depth with a DFS. The number of valid assignments depends only on that longest root-to-leaf path, so the answer is `2^(height - 1)`. A fast modular exponentiation routine keeps the result under `1_000_000_007`.

## Complexity
- Time: `O(n)`
- Space: `O(n)`

## Code Reference
See [Solution.java](Solution.java) for the implementation.
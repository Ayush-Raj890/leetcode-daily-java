# Day 141 - 3559. Number of Ways to Assign Edge Weights II

## Problem
Count the number of valid edge-weight assignments for each query on a tree.

## Approach
Root the tree at node `1`, then preprocess binary lifting tables for lowest common ancestor queries. For each query, compute the distance between the two nodes using their LCA. The number of valid assignments depends only on that path length, so the answer is `2^(dist - 1)` modulo `1_000_000_007`. A fast modular exponentiation routine handles the power calculation.

## Complexity
- Time: `O((n + q) log n)`
- Space: `O(n log n)`

## Code Reference
See [Solution.java](Solution.java) for the implementation.
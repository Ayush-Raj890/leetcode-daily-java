# Day 136 - 2196. Create Binary Tree From Descriptions

## Problem
Build the binary tree described by the parent-child relationships and return its root.

## Approach
Track every value in a map from node value to `TreeNode`. Use XOR to maintain the candidate root while processing each description: every value is added once when first seen, and each child is removed from the running root candidate when it appears as a child. After all descriptions are processed, the remaining value is the root.

## Complexity
- Time: `O(n)`
- Space: `O(n)`

## Code Reference
See [Solution.java](Solution.java) for the implementation.
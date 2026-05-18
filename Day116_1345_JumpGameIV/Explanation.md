# 1345. Jump Game IV

## Problem Description
Given an array of integers `arr`, you are initially positioned at index `0`. In one step, you can jump to any index `j` (where `j != i`) such that `arr[i] == arr[j]`, or you can jump to the adjacent index `i + 1` or `i - 1` if they exist. Return the minimum number of steps to reach the last index of the array.

## Solution Approach
- **Algorithm**: BFS (Breadth-First Search) with HashMap optimization
- **Time Complexity**: O(n)
- **Space Complexity**: O(n)

### Key Points:
1. Use a HashMap to store all indices for each unique value for O(1) lookup
2. Use BFS to find the minimum number of jumps
3. For each position, we can:
   - Jump to adjacent indices (i-1, i+1)
   - Jump to any index with the same value as current index
4. Use visited and added arrays to avoid revisiting and redundant additions
5. Remove indices from the map after processing to prevent revisiting
6. Early termination when reaching the last index

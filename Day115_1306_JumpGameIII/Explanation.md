# 1306. Jump Game III

## Problem Description
Given an array of non-negative integers `arr`, you are initially positioned at index `start`. When you are at index `i`, you can jump to `i + arr[i]` or `i - arr[i]`. Check if you can reach any index with value 0.

Notice that you can't jump outside of the array at any time.

## Solution Approach
- **Algorithm**: BFS (Breadth-First Search)
- **Time Complexity**: O(n)
- **Space Complexity**: O(n)

### Key Points:
1. Use a queue to explore all reachable indices
2. Maintain a visited array to avoid revisiting indices
3. For each index, we can jump either forward (`i + arr[i]`) or backward (`i - arr[i]`)
4. If we reach an index where the value is 0, return true
5. If we exhaust all reachable indices without finding 0, return false

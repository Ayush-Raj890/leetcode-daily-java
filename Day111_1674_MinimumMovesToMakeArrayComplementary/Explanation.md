# 1674. Minimum Moves to Make Array Complementary

## Problem
Given an array `nums` and an integer `limit`, minimize the number of moves to make every pair of numbers at symmetric positions sum to a target value within the range `[2, 2 * limit]`.

## Solution Approach
This solution uses a **difference array technique** to efficiently count the minimum number of moves:

1. **Difference Array**: Track range updates for all possible target sums
2. **For each symmetric pair** (nums[i], nums[n-1-i]):
   - Calculate the min and max of the pair
   - Mark which target sums require 0, 1, or 2 moves
3. **Prefix sum**: Compute cumulative moves for each target
4. **Return**: The minimum moves across all valid targets

## Complexity
- **Time**: O(n + limit) - linear scan through pairs and targets
- **Space**: O(limit) - for the difference array

## Key Insights
- Each pair can either stay the same (0 moves), change one element (1 move), or change both (2 moves)
- Difference array allows efficient range updates in O(1) per pair
- The optimal target sum is found by minimizing total moves

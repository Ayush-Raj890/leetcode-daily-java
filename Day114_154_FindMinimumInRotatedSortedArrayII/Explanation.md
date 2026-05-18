# 154. Find Minimum in Rotated Sorted Array II

## Problem
Find the minimum element in a rotated sorted array with duplicates.

## Solution Approach
Uses binary search with special handling for duplicates. When `nums[left] == nums[mid] == nums[right]`, we skip duplicate values at the boundaries to maintain the rotated array property and find the minimum element.

## Complexity
- Time: O(log n) average, O(n) worst case (when many duplicates)
- Space: O(1)

## Key Points
1. Compare middle element with the last element to determine which half contains the minimum
2. Skip duplicates at left and right boundaries when they equal the last element
3. Use binary search to efficiently narrow down the search space

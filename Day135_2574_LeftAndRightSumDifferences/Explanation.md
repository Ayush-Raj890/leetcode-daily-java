# Day 135 - 2574. Left and Right Sum Differences

## Problem
For each index, compute the absolute difference between the sum of elements to its left and the sum of elements to its right.

## Approach
First compute the total sum of the array. Then scan from left to right while maintaining a running left sum. For each index, the right sum is the total remaining sum after removing the current element, and the answer is `abs(leftSum - rightSum)`.

## Complexity
- Time: `O(n)`
- Space: `O(1)` excluding the output array

## Code Reference
See [Solution.java](Solution.java) for the implementation.
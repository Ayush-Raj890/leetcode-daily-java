# Day 142 - 2130. Maximum Twin Sum of a Linked List

## Problem
Find the maximum twin sum in an even-length linked list.

## Approach
Use a slow and fast pointer to reach the middle while reversing the first half of the list in place. When the fast pointer reaches the end, `prev` points to the reversed first half and `slow` points to the start of the second half. Then walk both halves together and compute the maximum sum of twin nodes.

## Complexity
- Time: `O(n)`
- Space: `O(1)`

## Code Reference
See [Solution.java](Solution.java) for the implementation.
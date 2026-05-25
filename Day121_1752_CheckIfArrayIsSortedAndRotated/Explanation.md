# Day 121 – 1752. Check if Array Is Sorted and Rotated

## Problem Statement

Given an integer array `nums`, return `true` if it is sorted in non-decreasing order and then rotated some number of positions, or `false` otherwise.

## Approach

A sorted-and-rotated array can have at most one place where an element is greater than the next element when we scan circularly.

1. Traverse every index `i`.
2. Compare `nums[i]` with `nums[(i + 1) % n]`.
3. Count how many times the order breaks.
4. If it breaks more than once, the array is not sorted and rotated.
5. Otherwise, it is valid.

## Complexity

- Time: `O(n)`
- Space: `O(1)`

## Code Reference

See `Solution.java` for the implementation.

# Day 120 – 33. Search in Rotated Sorted Array

## Problem
Given a rotated sorted array with distinct integers, return the index of `target` if it exists, otherwise return `-1`.

## Approach
The array is rotated at an unknown pivot, but both halves are still sorted. The solution uses two binary searches:

1. Find the rotation point by locating the smallest element.
2. Run a standard binary search, but map each mid index back into the rotated array using `(mid + rot) % n`.

This keeps the search `O(log n)` while avoiding separate handling for each half.

## Complexity
- Time: `O(log n)`
- Space: `O(1)`
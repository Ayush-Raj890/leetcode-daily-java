# Day 139 - 3691. Maximum Total Subarray Value II

## Problem
Choose up to `k` total subarray values and maximize the sum.

## Approach
For every starting index, track the best value for the current suffix window and keep shrinking that window one step at a time. A sparse table answers range minimum and maximum queries in `O(1)`, so each window value is computed as `max - min`. A max-heap always picks the current largest available value, adds it to the result, then pushes the next smaller window for the same start index back into the heap.

## Complexity
- Time: `O(n log n + k log n)`
- Space: `O(n log n)`

## Code Reference
See [Solution.java](Solution.java) for the implementation.
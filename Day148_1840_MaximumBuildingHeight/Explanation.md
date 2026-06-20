# Day 148 - 1840. Maximum Building Height

## Problem
Find the maximum possible building height while respecting the adjacency rule and the given restrictions.

## Approach
Treat the restrictions as height caps on specific positions, then add the fixed restriction at building `1` with height `0`. After sorting by position, sweep left to right to enforce the slope limit, then sweep right to left to enforce it again from the opposite side.

Once every restriction is valid from both directions, the tallest possible building between two neighboring restrictions is the peak of two lines that rise and fall by at most `1` per step. The formula computes that peak directly, and the last segment to building `num` is checked separately.

## Complexity
- Time: `O(r log r)`, where `r` is the number of restrictions
- Space: `O(r)`

## Code Reference
See [Solution.java](Solution.java) for the implementation.
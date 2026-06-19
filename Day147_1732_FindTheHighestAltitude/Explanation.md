# Day 147 - 1732. Find the Highest Altitude

## Problem
Track the highest altitude reached after applying each gain in order.

## Approach
Compute the altitude after every prefix of the `gain` array and keep the maximum value seen. The starting altitude is `0`, so that is also part of the answer.

## Complexity
- Time: `O(n^2)`
- Space: `O(1)`

## Code Reference
See [Solution.java](Solution.java) for the implementation.
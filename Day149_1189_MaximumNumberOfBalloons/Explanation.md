# Day 149 - 1189. Maximum Number of Balloons

## Problem
Count how many times the word `balloon` can be formed from the letters in a string.

## Approach
Count the available letters needed for `balloon`: `b`, `a`, `l`, `o`, and `n`. Since `l` and `o` are required twice, divide their counts by two before taking the minimum across all five letters.

## Complexity
- Time: `O(5n)`
- Space: `O(1)`

## Code Reference
See [Solution.java](Solution.java) for the implementation.
# Day 124 – 3120. Count the Number of Special Characters I

## Problem Statement
Given a string `word`, return the number of letters that appear in both lowercase and uppercase forms.

A character is considered special if both `a` and `A` appear in the string for the same letter.

## Approach
1. Track all lowercase letters in one bitmask.
2. Track all uppercase letters in another bitmask.
3. Compute the intersection of both masks.
4. Count the number of set bits in the intersection.

## Why This Works
Each bit represents one alphabet letter.
If the same letter appears in both cases, the corresponding bit will be set in both masks.
The bitwise AND keeps only those shared letters, and `Integer.bitCount()` counts them.

## Time and Space Complexity
- Time: O(n)
- Space: O(1)

## Code Reference
See [Solution.java](Solution.java) for the implementation.

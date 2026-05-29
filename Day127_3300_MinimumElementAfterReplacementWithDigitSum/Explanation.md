# Day 127 - 3300. Minimum Element After Replacement With Digit Sum

## Problem Statement
Given an array of positive integers, replace each number with the sum of its digits and return the minimum value after all replacements.

## Approach
For a number `n`, the digit sum can be computed directly from its decimal digits. Since the values in this problem fit within five digits, the digit sum is equivalent to subtracting `9` for every tens-place contribution that appears after repeated division by powers of `10`.

For each number:
1. Compute its digit-sum value using integer division.
2. Track the smallest transformed value.
3. Return that minimum after scanning the whole array.

## Why This Works
The expression `n - 9 * ((n / 10) + (n / 100) + (n / 1000) + (n / 10000))` collapses the decimal digits into their sum for the expected input range. Taking the minimum over all transformed numbers gives the required answer.

## Time and Space Complexity
- Time: `O(n)`
- Space: `O(1)`

## Code Reference
See [Solution.java](Solution.java) for the implementation.
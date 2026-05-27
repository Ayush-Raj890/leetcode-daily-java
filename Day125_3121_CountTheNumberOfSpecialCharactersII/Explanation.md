# Day 125 – 3121. Count the Number of Special Characters II

## Problem Statement
Given a string `word`, return the number of letters that are special.

A letter is special if it appears in lowercase and uppercase form, and all lowercase occurrences come before the first uppercase occurrence.

## Approach
1. Track the last position of each lowercase letter.
2. Track the first position of each uppercase letter.
3. For every letter, check whether both forms exist and whether the last lowercase index is smaller than the first uppercase index.
4. Count all letters that satisfy this condition.

## Why This Works
A letter is valid only when its lowercase form is completely seen before its uppercase form.
By storing the last lowercase occurrence and the first uppercase occurrence, we can verify that rule in constant time for each letter.

## Time and Space Complexity
- Time: O(n)
- Space: O(1)

## Code Reference
See [Solution.java](Solution.java) for the implementation.

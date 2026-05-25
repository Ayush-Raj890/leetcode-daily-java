# Day 123 – 1871. Jump Game VII

**Problem Link:** [LeetCode #1871: Jump Game VII](https://leetcode.com/problems/jump-game-vii/)

---

## Problem
Given a binary string `s` and jump bounds `minJ` and `maxJ`, determine whether you can reach the last index starting from index `0`, only landing on `'0'` characters.

## Approach
Use dynamic programming with a sliding window of reachable positions.

`dp[i]` marks whether index `i` is reachable. As we scan left to right:
- maintain how many reachable indices exist in the current jump window,
- mark `i` reachable if the window has at least one reachable position and `s[i] == '0'`,
- expand the farthest reachable bound whenever a new index becomes reachable.

This avoids checking every start position for every index.

## Complexity
- Time: `O(n)`
- Space: `O(n)`

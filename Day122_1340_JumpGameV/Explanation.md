# Day 122 – 1340. Jump Game V

**Problem Link:** [LeetCode #1340: Jump Game V](https://leetcode.com/problems/jump-game-v/)

---

## Problem
Given an array `arr` and a distance `d`, find the maximum number of indices you can visit by jumping left or right up to `d` positions at a time, but only to strictly smaller values and only until a value that is not smaller blocks further movement.

## Approach
Use DFS with memoization.

For each index, try all reachable positions to the left and right within distance `d`:
- stop scanning in that direction as soon as a value greater than or equal to the current one appears,
- otherwise continue exploring recursively.

The memo array stores the best answer starting from each index, so every index is solved once.

## Complexity
- Time: `O(n * d)`
- Space: `O(n)`
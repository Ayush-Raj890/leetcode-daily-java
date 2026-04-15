# Day 85 - Shortest Distance to Target String in a Circular Array

**Problem Link:** LeetCode #2515: Shortest Distance to Target String in a Circular Array

---

## Problem Statement
Given a circular array of strings, a target string, and a start index,
find the minimum number of steps needed to reach an index containing the target.
You can move left or right by one position, and wrapping around is allowed.
If the target does not exist in the array, return `-1`.

---

## Approach (Two-Direction Expansion)
1. Let `n` be the array length.
2. Check distances `i = 0` to `n / 2`.
3. For each `i`, test both circular positions from `start`:
   - Right: `(start + i) % n`
   - Left: `(start - i + n) % n`
4. If either position matches `target`, return `i` immediately.
5. If no match is found, return `-1`.

---

## Why This Works
At distance `i`, these are exactly the positions reachable in `i` moves
when moving only left or right on a circle.
By scanning `i` in increasing order, the first match guarantees the minimum distance.

---

## Time and Space Complexity
- **Time Complexity:** `O(n)`
- **Space Complexity:** `O(1)`

---

## Java Solution
See [Solution.java](Solution.java).

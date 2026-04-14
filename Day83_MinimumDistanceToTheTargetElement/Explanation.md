# Day 83 - Minimum Distance to the Target Element

**Problem Link:** LeetCode #1848: Minimum Distance to the Target Element

---

## Problem Statement
Given an integer array `nums`, an integer `target`, and an integer `start`,
find an index `i` such that `nums[i] == target` and `|i - start|` is minimum.
Return that minimum distance.

---

## Approach
Use a single pass through the array:
- Initialize `min` as a very large value.
- For each index `i`, if `nums[i] == target`, compute distance `|start - i|`.
- Update `min` with the smaller of current `min` and this distance.

After scanning all elements, `min` is the required answer.

---

## Why This Works
The solution checks every index where `target` appears.
For each valid index, it computes the exact distance from `start`.
Taking the minimum over all these distances guarantees the closest target position.

---

## Time and Space Complexity
- **Time Complexity:** `O(n)`
- **Space Complexity:** `O(1)`

---

## Java Solution
See [Solution.java](Solution.java).

# Day 80 - Minimum Distance Between Three Equal Elements I

**Problem Link:** LeetCode #3740: Minimum Distance Between Three Equal Elements I

---

## Problem Statement
Given an integer array `nums`, find the minimum distance between any three equal elements.

For any triple of equal values at indices `i < j < k`, the distance is `k - i`.
Return the minimum possible distance, or `-1` if no value appears at least three times.

---

## Approach
For each value, we only need to remember its last two occurrence indices.

When we see the next occurrence of the same value:
- If it is the second occurrence, store it.
- If it is the third or later occurrence, we can form a valid triple with the previous two positions.
- Update the answer with `currentIndex - firstStoredIndex`.
- Shift the stored positions forward.

This works because the smallest span for three equal values is always achieved by three consecutive occurrences in sorted index order.

---

## Why This Works
- Any valid triple of equal values can be represented by three indices in increasing order.
- For a fixed value, the best triple is one of its consecutive occurrence windows.
- Keeping only the last two positions is enough to evaluate every such window exactly once.

---

## Time and Space Complexity
- **Time Complexity:** `O(n)`
- **Space Complexity:** `O(m)` where `m` is the number of distinct values

---

## Java Solution
See [Solution.java](Solution.java).

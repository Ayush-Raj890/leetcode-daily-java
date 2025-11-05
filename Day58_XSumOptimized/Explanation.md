# 🧮 Day 58 – X-Sum (Optimized)

## 🧩 Problem Statement
Given an array `nums` of length `n` and integers `k` and `x`, for each sliding window of length `k` compute the x-sum:
- Count occurrences of each element in the window.
- Keep occurrences of the top `x` most frequent elements (tie-breaker: larger value wins).
- Sum value × frequency for those top `x` elements.
Return the x-sum for every window.

Constraints: n ≤ 50, nums[i] ≤ 50, 1 ≤ x ≤ k ≤ n.

## 💡 Idea (Optimized)
Maintain two ordered sets of distinct values in the current window:
- `topX`: the current top-x elements (by frequency desc, value desc).
- `rest`: the remaining elements.

Keep a frequency map and `sumTop` = sum(value × freq) for elements in `topX`. On each slide:
- When a value's frequency changes, remove it from its set, update freq, reinsert into `rest`.
- Rebalance sets to ensure `topX.size() == x` and every element in `topX` is at least as "good" as every element in `rest`.
- Record `sumTop` when window is full.

Rebalancing moves best candidates from `rest` to `topX` or swaps between sets based on frequency and value.

## 🔢 Example
For `nums = [1,1,2,2,3,4,2,3], k = 6, x = 2` the outputs are `[6,10,12]` (matches brute force but maintained incrementally).

## ⏱ Complexity
- Time: O(n · log d) amortized, where d = distinct values in window (d ≤ 50). Each insertion/removal/rebalance uses TreeSet operations.
- Space: O(d) for freq map and two sets.

## ✅ Notes
- Uses TreeSet with a comparator that consults the live frequency map; when frequency changes, elements must be removed and reinserted to maintain order.
- Works well for small value range; for very small universe (like nums[i] ≤ 50) an alternative counting-buckets approach is possible.
- `sumTop` avoids recomputing the sum for each window — update it incrementally on rebalances.
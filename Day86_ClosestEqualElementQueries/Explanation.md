# Day 86 - Closest Equal Element Queries

**Problem Link:** LeetCode #3488: Closest Equal Element Queries

---

## Problem Statement
You are given a circular array `nums` and query indices `queries`.
For each query index `q`, find the minimum circular distance from `q`
to another index `j` where `nums[j] == nums[q]`.
If no such index exists, return `-1` for that query.

---

## Approach (Index Buckets + Binary Search)
1. Build a map from value -> sorted list of indices where it appears.
2. For each query index `q`:
   - Get the list of indices for `nums[q]`.
   - If it appears once, answer is `-1`.
   - Use binary search to find `q` inside that index list.
   - Check only its immediate circular neighbors in that list (left and right).
3. Compute circular distance using:
   - `d = abs(a - b)`
   - `circular = min(d, n - d)`
4. Minimum of the two neighbor distances is the answer.

---

## Why This Works
For any fixed value, all its indices are sorted.
The closest equal index to `q` among those positions must be one of the two
adjacent positions around `q` in circular order.
Checking exactly these two neighbors guarantees the minimum circular distance.

---

## Time and Space Complexity
- Let `n = nums.length`, `k = queries.length`.
- Building the map: `O(n)`
- Each query: `O(log f)` for binary search, where `f` is frequency of `nums[q]`.
- Total: `O(n + k log n)` in worst case.
- Space: `O(n)`

---

## Java Solution
See [Solution.java](Solution.java).

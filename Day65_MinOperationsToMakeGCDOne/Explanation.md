# ⚙️ Day 65 – Minimum Operations to Make GCD One

## 🧩 Problem Summary
Given an integer array `nums`, in one operation you may replace any element by the gcd of it and an adjacent element. Return the minimum number of operations to make the gcd of the entire array equal to 1, or -1 if impossible.

## 💡 Approach
- Count how many elements are already 1. If there are `num1 > 0`, each non‑one can be turned into 1 in one operation by combining with an existing 1, so answer = `n - num1`.
- If the gcd of the whole array > 1, it's impossible to ever reach gcd 1 → return -1.
- Otherwise, no element is 1 but it is possible. Find the shortest subarray whose gcd is 1 (length = `minLen`). Turning that subarray into a single 1 requires `minLen - 1` operations (repeated gcd merges). After creating one 1, convert the remaining `n - 1` elements to 1 in one operation each. Total = `(minLen - 1) + (n - 1) = minLen + n - 2`.

## ⏱ Complexity
- Time: O(n^2) worst-case (finding minimal subarray with gcd 1 by scanning all starts).
- Space: O(1) extra.

## ✅ Notes
- Use an efficient gcd implementation; early exit when running gcd becomes 1.
- The algorithm handles large inputs within typical integer bounds.  
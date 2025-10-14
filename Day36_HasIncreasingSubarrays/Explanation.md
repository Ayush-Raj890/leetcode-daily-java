# Day 36 – Has Increasing Subarrays

## 🧠 Problem Statement
You are given a list of integers `nums` and an integer `k`.  
Determine whether the array contains two consecutive **increasing subarrays** of length at least `k` when combined.

## 📝 Approach
1. Traverse through the array while maintaining:
   - `inc` → current increasing subarray length.
   - `prevInc` → length of previous increasing subarray.
2. When the sequence breaks:
   - Update `prevInc` with `inc`.
   - Reset `inc` to 1.
3. At each step, calculate the maximum possible length of consecutive increasing subarrays using:
   - `Math.max(inc >> 1, Math.min(prevInc, inc))`.
4. If at any point `maxLen >= k`, return `true`.
5. If the loop completes without finding such a pair, return `false`.

## ⏳ Complexity
- **Time:** `O(n)` — single pass through the array.  
- **Space:** `O(1)` — only constant extra space used.

## 🧪 Example
Input: nums = [1, 2, 3, 2, 3, 4], k = 2
Output: true
Explanation:
Two increasing subarrays [1, 2, 3] and [2, 3, 4] overlap consecutively,
so length 2 is satisfied.

## 🏁 Key Insight
The problem relies on **detecting consecutive increasing sequences** and checking whether their combined length meets or exceeds `k`.

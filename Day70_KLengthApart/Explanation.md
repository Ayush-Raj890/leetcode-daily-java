# 📏 Day 70 – K Length Apart

## 🧩 Problem Statement (expanded)
Given a binary array nums and an integer k, determine whether every pair of consecutive 1s in nums has at least k zeros between them. Formally, for any indices i < j with nums[i] = nums[j] = 1 and there is no index t with i < t < j and nums[t] = 1, we require j - i - 1 >= k. Return true if the condition holds for all consecutive 1s, otherwise false.

## 💡 High-level idea
Scan the array left-to-right and remember the index of the previous 1 (lastIndex). Each time you see a new 1 at index i:
- If lastIndex is set (not -1), compute gap = i - lastIndex - 1.
- If gap < k, the requirement is violated → return false.
- Otherwise update lastIndex = i and continue.

This single-pass greedy check verifies the condition for every adjacent pair of 1s exactly once.

## ✅ Why this is correct
- The condition concerns only consecutive 1s (i.e., neighboring 1s in the sequence of indices that contain 1). Tracking the last seen 1 ensures we compare each new 1 with the nearest previous 1, so every consecutive pair is checked.
- If all consecutive pairs satisfy the gap constraint, any non-consecutive pair automatically satisfies it because their gap is the sum of gaps of intermediate consecutive pairs (thus larger or equal).

## ⏱ Complexity
- Time: O(n) — single pass over nums.
- Space: O(1) — only a few integer variables (lastIndex, i, k).

## 🔍 Edge cases & notes
- No 1s in nums → trivially true.
- Exactly one 1 → trivially true.
- k = 0 → always true (no gap required).
- Negative or invalid k is out of problem constraints (assume k >= 0).
- Works for large arrays since only indices and constant memory used.

## 🧪 Examples
- nums = [1,0,0,1], k = 2 → indices 0 and 3 → gap = 3-0-1 = 2 → OK → return true.
- nums = [1,0,1], k = 1 → gap = 1 → OK → true.
- nums = [1,0,1], k = 2 → gap = 1 < 2 → false.

## 🔧 Quick implementation (matching provided)
- Initialize lastIndex = -1.
- For i from 0..n-1:
  - If nums[i] == 1:
    - If lastIndex != -1 and i - lastIndex - 1 < k → return false.
    - lastIndex = i.
- Return true.

...existing code...
```// filepath: c:\Users\ayush\leetcode-daily-java\Day70_KLengthApart\Explanation.md
...existing code...
# 📏 Day 70 – K Length Apart

## 🧩 Problem Statement (expanded)
Given a binary array nums and an integer k, determine whether every pair of consecutive 1s in nums has at least k zeros between them. Formally, for any indices i < j with nums[i] = nums[j] = 1 and there is no index t with i < t < j and nums[t] = 1, we require j - i - 1 >= k. Return true if the condition holds for all consecutive 1s, otherwise false.

## 💡 High-level idea
Scan the array left-to-right and remember the index of the previous 1 (lastIndex). Each time you see a new 1 at index i:
- If lastIndex is set (not -1), compute gap = i - lastIndex - 1.
- If gap < k, the requirement is violated → return false.
- Otherwise update lastIndex = i and continue.

This single-pass greedy check verifies the condition for every adjacent pair of 1s exactly once.

## ✅ Why this is correct
- The condition concerns only consecutive 1s (i.e., neighboring 1s in the sequence of indices that contain 1). Tracking the last seen 1 ensures we compare each new 1 with the nearest previous 1, so every consecutive pair is checked.
- If all consecutive pairs satisfy the gap constraint, any non-consecutive pair automatically satisfies it because their gap is the sum of gaps of intermediate consecutive pairs (thus larger or equal).

## ⏱ Complexity
- Time: O(n) — single pass over nums.
- Space: O(1) — only a few integer variables (lastIndex, i, k).

## 🔍 Edge cases & notes
- No 1s in nums → trivially true.
- Exactly one 1 → trivially true.
- k = 0 → always true (no gap required).
- Negative or invalid k is out of problem constraints (assume k >= 0).
- Works for large arrays since only indices and constant memory used.

## 🧪 Examples
- nums = [1,0,0,1], k = 2 → indices 0 and 3 → gap = 3-0-1 = 2 → OK → return true.
- nums = [1,0,1], k = 1 → gap = 1 → OK → true.
- nums = [1,0,1], k = 2 → gap = 1 < 2 → false.

## 🔧 Quick implementation (matching provided)
- Initialize lastIndex = -1.
- For i from 0..n-1:
  - If nums[i] == 1:
    - If lastIndex != -1 and i - lastIndex - 1 < k → return false.
    - lastIndex = i.
- Return true.


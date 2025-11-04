# 🧮 Day 57 – X-Sum of Subarrays

## 🧩 Problem Statement

Given an integer array `nums` of length `n` and integers `k` and `x`, the x-sum of an array is computed by:
- Counting occurrences of each element,
- Keeping only occurrences of the top `x` most frequent elements (tie-breaker: larger value is more frequent),
- Summing the resulting array (i.e., sum value * frequency for those top x elements).

Return an array `answer` of length `n - k + 1` where `answer[i]` is the x-sum of the subarray `nums[i..i+k-1]`.

Constraints (relevant):
- 1 <= n <= 50
- 1 <= nums[i] <= 50
- 1 <= x <= k <= n

---

## 💡 Key Idea

Use a sliding window of size `k`. Maintain element frequencies for the current window. For each window, pick the top `x` entries by:
- frequency descending
- value descending (tie-breaker)

Sum value * frequency for those top `x` and record the result. Slide the window by decrementing the outgoing element's count and incrementing the incoming element's count.

---

## 🧠 Approach in the provided solution

- Maintain a HashMap `freq` for counts in the current window.
- For each window, build a max-heap (priority queue) keyed by `(frequency, value)` with comparator: higher freq first, if tie higher value first.
- Poll up to `x` elements from the heap and accumulate `freq * value`.
- Slide the window and update the map incrementally.

This is simple and efficient given small value range.

---

## 🔢 Example

Input:
```
nums = [1,1,2,2,3,4,2,3], k = 6, x = 2
```
Output:
```
[6, 10, 12]
```
Explanation (window 0): keep 1 and 2 → 1+1+2+2 = 6, etc.

---

## ⏱ Complexity

- Time: O((n - k + 1) * d log d) where d = number of distinct values in window (d ≤ 50). With constraints this is effectively O(n).
- Space: O(d) for the frequency map and heap.

---

## ✅ Notes / Optimizations

- Since nums[i] ≤ 50, you can replace the HashMap + heap with a fixed-size counting array (length 51) and a small list sort (or bucket by frequency) to avoid heap overhead.
- When k == x, answer[i] is just the sum of the window.

---

## 📌 Code Reference

See `Solution.java` in this folder for the implementation that uses HashMap + PriorityQueue.
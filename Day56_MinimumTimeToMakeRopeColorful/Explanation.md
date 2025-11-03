# 🧵 Day 56 – Minimum Time to Make Rope Colorful

## 🧩 Problem Statement

Given a string `colors` and an array `neededTime` where `neededTime[i]` is the time to remove the i-th balloon, remove balloons so that no two adjacent balloons have the same color. Return the minimum total time required.

LeetCode: 1578. Minimum Time to Make Rope Colorful

---

## 💡 Key Idea

Group consecutive balloons of the same color. For each group, to ensure only one remains, remove all but the one with the maximum removal time. Thus, for a group with total time S and max time M, cost = S - M.

---

## 🧠 Algorithm (Greedy)

- Iterate through the array, grouping consecutive indices with the same color.
- For each group compute:
  - currTotal = sum of neededTime in group
  - currMax = maximum neededTime in group
  - Add (currTotal - currMax) to answer
- Continue until the end.

This yields optimal result because keeping the most expensive balloon in a group minimizes removal cost.

---

## 🔢 Example

Input:
- colors = "aabbbcc"
- neededTime = [1,2,3,4,5,1,2]

Groups:
- "aa" → total 3, max 2 → cost 1
- "bbb" → total 12, max 5 → cost 7
- "cc" → total 3, max 2 → cost 1
Total cost = 9

---

## ⏱️ Complexity

- Time: O(n) — single pass over colors/neededTime
- Space: O(1) — constant extra space

---

## ✅ Notes

- Works in-place with two pointers scanning group boundaries.
- Avoids unnecessary removals by always preserving the highest-cost balloon in each same-color segment.
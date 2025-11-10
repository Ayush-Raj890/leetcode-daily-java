# 🧮 Day 63 – Minimum Operations to Make Array Increasing by Removing Subsequences

## 🧩 Problem Summary
Given an array `nums`, you may repeatedly remove a strictly decreasing subsequence (not necessarily contiguous) in one operation. Find the minimum number of operations required to make the array non-decreasing.

This solution counts the number of distinct values that need to appear as increasing "layers" using a monotonic stack.

## 💡 Key Idea
Maintain a monotone-non-decreasing stack of values representing the current active layers. For each element:
- Pop larger elements from the stack (they would block a non-decreasing arrangement).
- Skip zeros (they don't require layers).
- If the stack is empty or top < current value, create a new layer (push value and increment answer).

This effectively counts how many increasing layers are needed when removing decreasing subsequences greedily.

## 🧠 Algorithm (Greedy + Monotonic Stack)
- Initialize empty stack and result = 0.
- For each value `v` in `nums`:
  - While stack not empty and stack.peek() > v: stack.pop()
  - If v == 0: continue
  - If stack empty or stack.peek() < v: push v; result++
- Return result.

## ⏱ Complexity
- Time: O(n) amortized — each element is pushed/popped at most once.
- Space: O(n) for the stack in the worst case.

## 🔢 Example
nums = [1,3,2,1,2]
- Process 1 → push(1) res=1
- 3 → push(3) res=2
- 2 → pop 3, top 1 < 2 → push(2) res=3
- 1 → pop 2, pop 1 → v==1 push(1) res=4
- 2 → top 1 < 2 → push(2) res=5
Answer = 5

## ✅ Notes
- Zeros are ignored because they don't require operations.
- Equivalent interpretations relate this to computing the length of a minimal partition into non-decreasing subsequences.
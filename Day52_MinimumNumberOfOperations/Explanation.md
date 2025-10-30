# 🎯 Day 52 – Minimum Number of Operations

## 🧩 Problem Statement

You are given an integer array `target` of length `n`. Starting with an array of `n` zeros, you need to perform operations to transform it into the target array.

In one operation, you can:
- Choose any subarray and increment all elements in it by 1.

Return the **minimum number of operations** required to build the target array.

**LeetCode Problem**: [1526. Minimum Number of Increments on Subarrays to Form a Target Array](https://leetcode.com/problems/minimum-number-of-increments-on-subarrays-to-form-a-target-array/)

---

## 💡 Examples

### Example 1:
**Input:**  
`target = [1,2,3,2,1]`

**Output:**  
`3`

**Explanation:**  
- Operation 1: [0,0,0,0,0] → [1,1,1,1,1]
- Operation 2: [1,1,1,1,1] → [1,2,2,2,1]
- Operation 3: [1,2,2,2,1] → [1,2,3,2,1]
- **Total**: 3 operations

### Example 2:
**Input:**  
`target = [3,1,1,2]`

**Output:**  
`4`

**Explanation:**  
- Operation 1: [0,0,0,0] → [1,1,1,1]
- Operation 2: [1,1,1,1] → [2,1,1,1]
- Operation 3: [2,1,1,1] → [3,1,1,1]
- Operation 4: [3,1,1,1] → [3,1,1,2]
- **Total**: 4 operations

### Example 3:
**Input:**  
`target = [3,1,5,4,2]`

**Output:**  
`7`

---

## 🧠 Approach

This solution uses a **greedy algorithm** based on the observation that we need to account for increases in the array:

1. **Key Insight:**
   - Start with the first element: we need `target[0]` operations to reach it from 0.
   - For each subsequent element, we only need additional operations if it's **greater** than the previous element.
   - If `target[i] > target[i-1]`, we need `target[i] - target[i-1]` more operations.
   - If `target[i] <= target[i-1]`, no additional operations needed (we can reuse previous increments).

2. **Algorithm:**
   - Initialize `ans = target[0]` (operations for first element)
   - For each element from index 1 to n-1:
     - Add `max(target[i] - target[i-1], 0)` to ans
   - Return ans

3. **Why This Works:**
   - When an element increases, we need to increment only that position onwards.
   - When an element decreases or stays same, previous operations already cover it.
   - We're essentially counting all the "upward steps" in the array.

---

## 📊 Visual Example

**Input:** `target = [1,2,3,2,1]`

```
Height
3 |     ▓
2 |   ▓ ▓ ▓
1 | ▓ ▓ ▓ ▓ ▓
  +----------
    0 1 2 3 4
```

**Operations count:**
- Position 0: Need 1 operation (increase from 0 to 1)
- Position 1: Need 1 more (increase from 1 to 2) → Total: 2
- Position 2: Need 1 more (increase from 2 to 3) → Total: 3
- Position 3: No new operations (decrease from 3 to 2)
- Position 4: No new operations (decrease from 2 to 1)

**Total**: 3 operations

---

## ⏱️ Complexity

| Type  | Complexity |
|-------|------------|
| Time  | O(n)       |
| Space | O(1)       |

---

## ✅ Code Reference

See `Solution.java` for the implementation.

---

## 🎯 Key Insights

- **Count upward transitions**: Only increases require new operations
- **Greedy approach**: Process left to right, counting increments
- **No backtracking needed**: Each position is processed once
- **Optimal solution**: Can't do better than counting all necessary increments

---

## 📝 Notes

- The problem is equivalent to finding the sum of all positive differences between consecutive elements plus the first element.
- Think of it as climbing stairs: you only count steps going up.
- Decreases don't cost operations because we can use subarrays that don't include later positions.

---

## 💡 Mathematical Insight

The answer can be expressed as:
```
ans = target[0] + Σ(max(target[i] - target[i-1], 0)) for i = 1 to n-1
```

This is equivalent to:
```
ans = target[0] + sum of all positive differences
```

---

## 🔍 Edge Cases

- Single element: `target = [5]` → `5` operations
- All increasing: `target = [1,2,3,4,5]` → `5` operations
- All decreasing: `target = [5,4,3,2,1]` → `5` operations
- Constant array: `target = [3,3,3,3]` → `3` operations

---

## 🌟 Alternative Interpretation

Think of the array as a histogram:
- Each operation fills a horizontal layer
- We need as many layers as the sum of all increases from left to right
- This matches the visual "area under the curve" when looking at increments

---
# Day 22 – Triangular Sum of an Array

**Problem Link:** [LeetCode #2221: Find Triangular Sum of an Array](https://leetcode.com/problems/find-triangular-sum-of-an-array/)

---

## Problem Statement
You are given a 0-indexed integer array `nums`, where `nums[i]` is a digit between 0 and 9 (inclusive).  
Your task is to return the **triangular sum** of `nums`.

The triangular sum is defined by repeatedly replacing each adjacent pair of numbers with their sum modulo 10, until only one number remains.

---

## Approach
- If the array has only one element, that element is the triangular sum.  
- Otherwise:
  1. Create a new array `newNums` of size `n-1`.
  2. For each adjacent pair `(nums[i], nums[i+1])`, compute `(nums[i] + nums[i+1]) % 10` and store it in `newNums[i]`.
  3. Recursively call the function on `newNums`.
- Eventually, the recursion reduces the array to one element, which is returned.

---

## Dry Run
**Input:** `nums = [1,2,3,4,5]`  

- Step 1: `[1,2,3,4,5] → [3,5,7,9] → [3,5,7,9] % 10 = [3,5,7,9]`
- Step 2: `[3,5,7,9] → [8,2,6]`
- Step 3: `[8,2,6] → [0,8]`
- Step 4: `[0,8] → [8]`

**Output:** `8`

---

## Time & Space Complexity
- **Time Complexity:** O(n²) → In the worst case, we process `n + (n-1) + (n-2) + ... + 1 ≈ n²/2` elements.  
- **Space Complexity:** O(n) → due to recursive stack depth and new arrays created at each step.

---

## Significance
- Demonstrates recursive problem-solving with array transformations.  
- Teaches how to work with **modulo arithmetic** in iterative/recursive processes.  
- Strengthens understanding of **recursion vs. iteration trade-offs**.

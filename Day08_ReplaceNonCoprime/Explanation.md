# Day 08 – Replace Non-Coprime Numbers in Array

**Problem Link:** [LeetCode #2197: Replace Non-Coprime Numbers in Array](https://leetcode.com/problems/replace-non-coprime-numbers-in-array/)

---

## Problem Statement
You are given an integer array `nums`.  

- Repeatedly find any two adjacent numbers that are **non-coprime** (i.e., their GCD > 1).  
- Replace them with their **LCM** (Least Common Multiple).  
- Continue until no two adjacent numbers are non-coprime.  

Return the resulting array.

---

## Approach
1. Use a **stack** to maintain the processed numbers.  
2. For each number in `nums`:  
   - Push it into the stack.  
   - While the top two numbers of the stack are **non-coprime**:  
     - Pop both.  
     - Replace them with their **LCM**.  
     - Push the new LCM back into the stack.  
   - Repeat until the top two are coprime.  
3. At the end, the stack contains the final array.  

### Why Stack?
- A stack naturally handles the **adjacency requirement**.  
- Whenever a new number is added, only the top of the stack can interact with it.  
- This avoids unnecessary re-checking of non-adjacent elements.  

---

## Dry Run
**Input:**  
`nums = [6, 4, 3, 2, 7, 6, 2]`  

**Process:**  
- Start with empty stack.  
- Push 6 → stack = [6]  
- Push 4 → gcd(6,4) = 2 → non-coprime → replace with lcm(6,4) = 12 → stack = [12]  
- Push 3 → gcd(12,3) = 3 → non-coprime → lcm(12,3) = 12 → stack = [12]  
- Push 2 → gcd(12,2) = 2 → non-coprime → lcm(12,2) = 12 → stack = [12]  
- Push 7 → gcd(12,7) = 1 → coprime → stack = [12,7]  
- Push 6 → gcd(7,6) = 1 → coprime → stack = [12,7,6]  
- Push 2 → gcd(6,2) = 2 → non-coprime → lcm(6,2) = 6 → stack = [12,7,6]  

**Output:** `[12, 7, 6]`  

---

## Time & Space Complexity
- **Time Complexity:** O(N log M)  
  - Each number is pushed/popped at most once.  
  - GCD/LCM calculations take O(log M), where M = max element.  
- **Space Complexity:** O(N)  
  - Stack can hold up to N elements.  

---

## Significance
- Demonstrates **stack-based greedy merging**.  
- Reinforces the use of **GCD and LCM** in array transformations.  
- Good practice for handling iterative merging until a condition stabilizes.

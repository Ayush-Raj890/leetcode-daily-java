# Day 02 – Reverse Integer

**Problem Link:** [LeetCode #7: Reverse Integer](https://leetcode.com/problems/reverse-integer/)

---

## Problem Statement
Given a signed 32-bit integer `x`, return the integer obtained by reversing its digits.  
If reversing causes the value to go outside the range  
\[-2³¹, 2³¹ - 1\] → \[-2147483648, 2147483647\], return `0`.

---

## Approach
- Extract digits from `x` one by one using modulus (`% 10`).  
- Build the reversed number by multiplying the current result by `10` and adding the digit.  
- Divide `x` by `10` each step to remove the last digit.  
- Use a `long` variable during calculation to detect overflow.  
- If the reversed number is outside the 32-bit range, return `0`.  

---

## Dry Run
**Input:** `x = -123`  

- Step 1: digit = -123 % 10 = -3 → rev = 0 * 10 + (-3) = -3 → x = -12  
- Step 2: digit = -12 % 10 = -2 → rev = -3 * 10 + (-2) = -32 → x = -1  
- Step 3: digit = -1 % 10 = -1 → rev = -32 * 10 + (-1) = -321 → x = 0  

**Output:** `-321`

---

## Time & Space Complexity
- **Time Complexity:** O(log n) → each digit is processed once.  
- **Space Complexity:** O(1) → only a few variables are used.  

---

## Significance
- Teaches careful handling of **overflow** in integer operations.  
- Reinforces the concept of digit extraction and number reconstruction.  
- Builds foundation for more complex math/number manipulation problems.  

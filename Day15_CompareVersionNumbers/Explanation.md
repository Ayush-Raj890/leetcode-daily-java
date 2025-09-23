# Day 15 – Compare Version Numbers

**Problem Link:** [LeetCode #165: Compare Version Numbers](https://leetcode.com/problems/compare-version-numbers/)

---

## Problem Statement
Given two version numbers, `version1` and `version2`, compare them.

- If `version1` < `version2`, return **-1**.  
- If `version1` > `version2`, return **1**.  
- Otherwise, return **0**.  

A version string consists of numbers separated by dots `"."`. Each number is non-negative and may contain leading zeros. The comparison should be made **numerically** and not lexicographically. Leading zeros should be ignored.

---

## Approach
1. **Split Versions:**  
   Use `split("\\.")` to break both version strings into parts.  

2. **Normalize Lengths:**  
   Since versions may have different lengths, compare up to the maximum length. If one version runs out of parts, treat missing parts as `0`.  

3. **Compare Parts:**  
   Convert each part into an integer and compare:
   - If one is greater, return `1` or `-1`.  
   - If equal, move to the next part.  

4. **Return 0:**  
   If all parts are equal, return `0`.  

---

## Example Dry Run
**Input:**  
`version1 = "1.01", version2 = "1.001"`  

- Split → v1 = `[1, 01]`, v2 = `[1, 001]`  
- Compare index 0: `1 == 1` → continue  
- Compare index 1: `01 == 001` → both are `1` → continue  
- End of comparison → return `0`  

**Output:**  
`0`

---

## Time & Space Complexity
- **Time Complexity:** `O(n + m)`  
  where `n` and `m` are the number of parts in `version1` and `version2`.  
- **Space Complexity:** `O(n + m)` for storing split parts.  

---

## Significance
- Highlights handling of **string parsing and numeric comparison**.  
- Demonstrates careful handling of **leading zeros**.  
- Useful for real-world applications like **software version control systems**.  

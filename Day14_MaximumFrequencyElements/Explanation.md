# Day 14 – Maximum Frequency Elements

## Problem Statement
You are given an integer array `nums`.  
The frequency of an element is the number of times it appears in the array.  

You need to return the **sum of the frequencies of all elements that appear most frequently** in the array.

### Example 1
**Input:**
nums = [1,2,2,3,1,4]
**Output:**
**Explanation:**
- Frequencies: 1 → 2, 2 → 2, 3 → 1, 4 → 1  
- The maximum frequency is **2**, and elements `{1, 2}` both appear with this frequency.  
- Total = 2 (for 1) + 2 (for 2) = **4**

---

### Example 2
**Input:**
nums = [1,2,3,4,5]
**Output:**
5
**Explanation:**
- All elements have frequency **1**, which is the maximum frequency.  
- Total = 1+1+1+1+1 = **5**

---

## Approach

1. Use a frequency counter (`freq`) to count how many times each element appears.
2. Track two variables:
   - `max` → the maximum frequency seen so far.
   - `res` → the total sum of frequencies for elements that match the maximum.
3. For each element:
   - If the new frequency is greater than `max`, update `max` and reset `res` to this new frequency.
   - If the new frequency equals `max`, add it to `res`.

This way, we avoid traversing the map multiple times.

---

## Complexity Analysis
- **Time Complexity:** `O(n)` → We traverse the array once.  
- **Space Complexity:** `O(1)` → Since numbers are within `[1, 100]`, frequency array size is fixed at 101.

---

## Why This Approach?
- Using a fixed-size frequency array (`byte[101]`) is memory efficient compared to a HashMap.  
- We maintain maximum frequency dynamically while counting, so we don’t need a second loop.  
- This ensures the solution is both simple and optimal.

---

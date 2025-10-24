# 🎨 Day 46 – Next Beautiful Number

## 🧩 Problem Statement

A **beautiful number** is a positive integer where each digit `d` appears exactly `d` times in the number.

Given an integer `n`, return the **smallest beautiful number** that is strictly greater than `n`.

**LeetCode Problem**: [2048. Next Beautiful Number](https://leetcode.com/problems/next-beautiful-number/)

---

## 💡 Examples

### Example 1:
**Input:**  
`n = 1`

**Output:**  
`22`

**Explanation:**  
22 is beautiful because digit 2 appears exactly 2 times.

### Example 2:
**Input:**  
`n = 1000`

**Output:**  
`1333`

**Explanation:**  
1333 is beautiful because digit 1 appears 1 time and digit 3 appears 3 times.

### Example 3:
**Input:**  
`n = 3000`

**Output:**  
`3133`

**Explanation:**  
3133 is beautiful because digit 1 appears 1 time and digit 3 appears 3 times.

---

## 🧠 Approach

This solution uses **backtracking with pruning** to generate all beautiful numbers up to a certain limit, then finds the smallest one greater than `n`:

1. **Generate Beautiful Numbers:**
   - Use backtracking to build numbers digit by digit (from 1 to 7).
   - Track the count of each digit using a `count[]` array.
   - Only include digits where the count matches the digit value (e.g., digit 3 must appear exactly 3 times).

2. **Pruning:**
   - Stop generating when the number exceeds `1224444` (the maximum possible 7-digit beautiful number).
   - Only add digits if their count is less than the digit value itself.

3. **Validation:**
   - A number is beautiful if every digit `d` that appears does so exactly `d` times.
   - The `isBeautiful()` method checks this condition.

4. **Find Result:**
   - Sort all generated beautiful numbers.
   - Return the first number greater than `n`.

---

## 📊 Algorithm Steps

1. **Initialization:**
   - Create an empty list to store beautiful numbers.
   - Start with `num = 0` and `count[]` array initialized to zeros.

2. **Backtracking:**
   - Try adding each digit from 1 to 7.
   - Increment the count for that digit.
   - Recursively generate the next digit.
   - Backtrack by decrementing the count.

3. **Base Cases:**
   - If `num > 0` and passes the beautiful check, add to list.
   - If `num > 1224444`, stop (pruning).

4. **Final Step:**
   - Sort the list and find the first number `> n`.

---

## ⏱️ Complexity

| Type  | Complexity |
|-------|------------|
| Time  | O(k log k) where k is the number of beautiful numbers generated (~1500) |
| Space | O(k) for storing the list |

---

## ✅ Code Reference

See `Solution.java` for the implementation.

---

## 🎯 Key Insights

- **Beautiful numbers are rare**: There are only about 1500 beautiful numbers up to 1224444.
- **Digits 1-7 only**: No digit can be 0, 8, or 9 (since you can't have 8 or 9 occurrences in a reasonably sized number).
- **Backtracking is efficient**: Pre-generating all beautiful numbers is faster than checking each candidate number.

---

## 📝 Notes

- The maximum 7-digit beautiful number is `1224444` (1 appears once, 2 appears twice, 4 appears four times).
- This approach is much faster than brute-force checking every number after `n`.
- The sorted list allows binary search for even faster lookup if needed.

---
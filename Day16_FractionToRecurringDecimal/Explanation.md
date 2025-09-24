# Day 16 – Fraction to Recurring Decimal

**Problem Link:** [LeetCode #166: Fraction to Recurring Decimal](https://leetcode.com/problems/fraction-to-recurring-decimal/)

---

## Problem Statement
Given two integers `numerator` and `denominator`, return the fraction `numerator/denominator` as a **string**.

- If the fractional part is recurring, enclose the recurring sequence in parentheses.
- If the result is negative, it should start with `"-"`.
- If the fraction has no decimal part, return only the integer.

---

## Approach
1. **Handle Zero:**  
   If `numerator == 0`, return `"0"` immediately.

2. **Handle Sign:**  
   Use XOR (`^`) to detect if exactly one of `numerator` or `denominator` is negative. If so, add `"-"` to the result.

3. **Use Long Type:**  
   Convert numerator and denominator to `long` and use absolute values to avoid overflow (e.g., `Integer.MIN_VALUE`).

4. **Integer Part:**  
   Append `numerator / denominator` to the result.  
   Compute remainder `numerator % denominator`.

5. **Fractional Part:**  
   - If remainder is `0`, return the integer result.  
   - Otherwise, append `"."` and start simulating long division.

6. **Recurring Detection:**  
   Use a `Map<Long, Integer>` to track each remainder and the index in the result string where it first appeared.  
   - If a remainder repeats, insert `"("` at the stored index and append `")"` at the end.  
   - This marks the recurring part.

7. **Build Result:**  
   Continue until remainder becomes `0` or a cycle is detected.

---

## Example Dry Run
**Input:**  
`numerator = 1, denominator = 3`  

- Integer part: `1 / 3 = 0`, remainder = 1 → result = `"0."`  
- Multiply remainder by 10 → 10 / 3 = 3, remainder = 1  
- Remainder 1 repeats → recurring sequence starts  
- Insert `"("` before the first `3` and append `")`  

**Output:**  
`"0.(3)"`

---

## Time & Space Complexity
- **Time Complexity:** `O(n)`  
  where `n` is the length of the recurring cycle (at most denominator size).  
- **Space Complexity:** `O(n)`  
  for storing remainders in the map.

---

## Significance
- Demonstrates handling of **recurring decimals** using hashing.  
- Reinforces **long division simulation**.  
- Covers **edge cases** like negative fractions, terminating decimals, and integer overflow.  

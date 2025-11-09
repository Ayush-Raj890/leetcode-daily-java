# 🔢 Day 62 – Count Operations to Obtain Zero

## 🧩 Problem
Given two positive integers n1 and n2, repeatedly perform the operation: subtract the smaller from the larger (counting each subtraction as one operation) until one of the numbers becomes 0. Return the total number of operations.

This can be accelerated by using division: when a >= b, replacing a by a % b is equivalent to performing a / b subtractions and leaves a % b as remainder.

LeetCode: 2169. Count Operations to Obtain Zero

## 💡 Key Idea
- Use the Euclidean-style approach: while both numbers are > 0, add a / b to the count and set a = a % b, then swap.
- This counts many repeated subtractions in O(1) per step (using division) instead of iterating each subtraction.

## 🧠 Algorithm
1. Initialize count = 0.
2. While n1 > 0 and n2 > 0:
   - count += n1 / n2
   - n1 = n1 % n2
   - swap(n1, n2)
3. Return count.

## ⏱ Complexity
- Time: O(log(min(n1, n2))) — same complexity as the Euclidean GCD algorithm.
- Space: O(1).

## 🔢 Example
Input: n1 = 5, n2 = 3  
Steps (fast view): 5/3 = 1 → count=1, n1=5%3=2, swap → (3,2)  
3/2 = 1 → count=2, n1=1, swap → (2,1)  
2/1 = 2 → count=4, n1=0 → stop → answer = 4

## ✅ Notes
- The division-based approach is mathematically equivalent to repeated subtraction but much faster.
- Works for large inputs within integer limits.
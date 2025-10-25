# 💰 Day 47 – Calculate Money in Leetcode Bank

## 🧩 Problem Statement

Hercy wants to save money for his first car. He puts money in the Leetcode bank every day.

On the first day (Monday), he puts in $1. Every subsequent day, he puts in $1 more than the day before. Every Monday, he starts with $1 more than the previous Monday.

Given `n` days, calculate the **total amount of money** he will have in the Leetcode bank at the end of the nth day.

**LeetCode Problem**: [1716. Calculate Money in Leetcode Bank](https://leetcode.com/problems/calculate-money-in-leetcode-bank/)

---

## 💡 Examples

### Example 1:
**Input:**  
`n = 4`

**Output:**  
`10`

**Explanation:**  
- Day 1 (Monday): $1
- Day 2 (Tuesday): $2
- Day 3 (Wednesday): $3
- Day 4 (Thursday): $4
- **Total**: 1 + 2 + 3 + 4 = $10

### Example 2:
**Input:**  
`n = 10`

**Output:**  
`37`

**Explanation:**  
- Week 1: 1 + 2 + 3 + 4 + 5 + 6 + 7 = 28
- Week 2 (Days 8-10): 2 + 3 + 4 = 9
- **Total**: 28 + 9 = $37

### Example 3:
**Input:**  
`n = 20`

**Output:**  
`96`

**Explanation:**  
- Week 1: 1+2+3+4+5+6+7 = 28
- Week 2: 2+3+4+5+6+7+8 = 35
- Week 3 (Days 15-20): 3+4+5+6+7+8 = 33
- **Total**: 28 + 35 + 33 = $96

---

## 🧠 Approach

This solution uses a **mathematical formula** to calculate the total money without iterating through each day:

1. **Break Down the Problem:**
   - Calculate the number of complete weeks: `nWeeks = days / 7`
   - Calculate the remaining days: `rDays = days % 7`

2. **Triangular Sum Formula:**
   - The sum of first `n` natural numbers: `triSum(n) = n * (n + 1) / 2`

3. **Total Calculation:**
   - If all days were counted sequentially (1, 2, 3, ..., days), the sum would be `triSum(days)`.
   - But we need to adjust for the weekly pattern where each Monday starts fresh with an increment.

4. **Adjustment Formula:**
   ```
   Total = triSum(days) - 42 * triSum(nWeeks - 1) - 6 * nWeeks * rDays
   ```
   - `42 * triSum(nWeeks - 1)`: Adjusts for the extra increments from complete weeks
   - `6 * nWeeks * rDays`: Adjusts for the remaining days in the incomplete week

---

## 📊 Mathematical Breakdown

**Why this formula works:**

1. **Base sum**: `triSum(days)` gives us 1+2+3+...+days
2. **Weekly adjustments**: 
   - Each complete week adds an extra increment pattern
   - The formula corrects for these increments using the triangular sum of weeks
3. **Remaining days**: The partial week needs adjustment based on how many complete weeks have passed

---

## ⏱️ Complexity

| Type  | Complexity |
|-------|------------|
| Time  | O(1)       |
| Space | O(1)       |

---

## ✅ Code Reference

See `Solution.java` for the implementation.

---

## 🎯 Key Insights

- **Constant time solution**: No loops needed, pure mathematical formula
- **Bit shift optimization**: Uses `>> 1` instead of `/ 2` for faster division
- **Pattern recognition**: Recognizes the arithmetic progression pattern in the problem

---

## 📝 Notes

- The pattern repeats every week with an increment
- Week 1: 1, 2, 3, 4, 5, 6, 7 (sum = 28)
- Week 2: 2, 3, 4, 5, 6, 7, 8 (sum = 35)
- Week 3: 3, 4, 5, 6, 7, 8, 9 (sum = 42)
- Each week's sum increases by 7

---

## 🔢 Alternative Approach

A simpler iterative approach would be:
```java
int total = 0;
int monday = 1;
for (int week = 0; week < nWeeks; week++) {
    total += 7 * monday + 21; // 1+2+3+4+5+6 = 21
    monday++;
}
for (int day = 0; day < rDays; day++) {
    total += monday + day;
}
```

However, the mathematical formula is more elegant and efficient!

---
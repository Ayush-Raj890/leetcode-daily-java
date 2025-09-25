# Day 17 – Triangle

**Problem Link:** [LeetCode #120: Triangle](https://leetcode.com/problems/triangle/)

---

## Problem Statement
Given a triangle array, return the **minimum path sum** from top to bottom.

At each step, you may move to an adjacent number of the row below.  
Formally, if you are on index `j` in row `i`, you may move to index `j` or `j + 1` in row `i + 1`.

---

## Approach
We use **Dynamic Programming (Bottom-Up)**:

1. Start from the **second-last row** of the triangle.  
2. For each element in that row, update it as the element value plus the **minimum** of its two adjacent elements in the row below.  
3. Continue this process upwards until we reach the top row.  
4. The top element will contain the minimum path sum.

This avoids recursion and reduces space usage by updating the triangle **in-place**.

---

## Example Dry Run
**Input:**  
```

[
[2],
[3,4],
[6,5,7],
[4,1,8,3]
]

```

- Start from row 2 (`[6,5,7]`):  
  - Update 6 → 6 + min(4,1) = 7  
  - Update 5 → 5 + min(1,8) = 6  
  - Update 7 → 7 + min(8,3) = 10  
  → Row becomes `[7,6,10]`  

- Row 1 (`[3,4]`):  
  - Update 3 → 3 + min(7,6) = 9  
  - Update 4 → 4 + min(6,10) = 10  
  → Row becomes `[9,10]`  

- Row 0 (`[2]`):  
  - Update 2 → 2 + min(9,10) = 11  

**Output:**  
`11`

---

## Time & Space Complexity
- **Time Complexity:** `O(n²)` – every element of the triangle is processed once.  
- **Space Complexity:** `O(1)` – in-place modification of the triangle.  

---

## Significance
- Classic **Dynamic Programming** problem.  
- Teaches **bottom-up optimization** and **in-place updates**.  
- Builds foundation for other DP grid-based problems.  
```

---

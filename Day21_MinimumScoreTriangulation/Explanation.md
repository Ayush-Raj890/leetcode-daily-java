# Day 21 – Minimum Score Triangulation of Polygon (LeetCode 1039)

## Problem Statement
You are given a convex polygon with `n` vertices, each vertex has a value.  
Your task is to triangulate the polygon into `n-2` triangles such that the **sum of the triangle scores** is minimized.  

The **score of a triangle** is the product of the three vertex values.  
Return the **minimum total score**.

---

## Example
**Input:**
values = [1,2,3]

**Output:**

6

**Explanation:**
There’s only one possible triangulation: triangle (1,2,3) with score = `1*2*3 = 6`.

---

**Input:**

**Explanation:**
There’s only one possible triangulation: triangle (1,2,3) with score = `1*2*3 = 6`.

---

**Input:**
values = [3,7,4,5]


**Output:**
144


**Explanation:**
Two triangulations possible:
1. Triangles (3,7,4) and (3,4,5) → score = `84 + 60 = 144`
2. Triangles (3,7,5) and (7,4,5) → score = `105 + 140 = 245`  
So the minimum is **144**.

---

## Approach
We use **Dynamic Programming (DP)** to solve this problem.

1. **State Definition**  
   Let `dp[i][j]` represent the minimum triangulation score of the sub-polygon from vertex `i` to vertex `j`.

2. **Transition**  
   To triangulate between vertices `i` and `j`, pick an intermediate vertex `k` (`i < k < j`).  
   The score is:


dp[i][j] = min(
dp[i][k] + (values[i] * values[k] * values[j]) + dp[k][j]
)


3. **Initialization**  
- When `j <= i+1`, no triangle can be formed → `dp[i][j] = 0`.

4. **Final Answer**  
The minimum triangulation score for the entire polygon is `dp[0][n-1]`.

---

## Dry Run
Input: `values = [3,7,4,5]`

- Start with smaller ranges and expand:
- `dp[0][2] = 3*7*4 = 84`
- `dp[1][3] = 7*4*5 = 140`
- For `dp[0][3]`:
- Choose `k=1`: `dp[0][1] + 3*7*5 + dp[1][3] = 0 + 105 + 140 = 245`
- Choose `k=2`: `dp[0][2] + 3*4*5 + dp[2][3] = 84 + 60 + 0 = 144`
- Minimum = `144`

Answer = `144`.

---

## Complexity Analysis
- **Time Complexity:** `O(n^3)` → 3 nested loops (i, j, k).  
- **Space Complexity:** `O(n^2)` → 2D DP table.

---

## Significance
- Demonstrates **interval DP** on polygons.  
- Useful in computational geometry and optimization problems.  
- Strengthens understanding of **dynamic programming over ranges**.



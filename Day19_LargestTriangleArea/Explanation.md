# Day 19 – Largest Triangle Area

## Problem Statement
You are given an array of points on a 2D plane. Each point is represented as `[x, y]`.  
Return the area of the **largest triangle** that can be formed by any three points.

**LeetCode Problem:** [812. Largest Triangle Area](https://leetcode.com/problems/largest-triangle-area/)

---

## Example

### Example 1:
**Input:**
points = [[0,0],[0,1],[1,0],[0,2],[2,0]]
**Output:**
2.0

**Explanation:**  
The largest triangle is formed by points `(0,2), (2,0), (0,0)` which has an area of `2.0`.

---

## Approach

1. **Brute force checking of all triplets:**
   - Iterate over all combinations of 3 points `(i, j, k)`.
   - Use the **shoelace formula** to calculate the area:
     ```
     Area = 0.5 * |x1(y2 − y3) + x2(y3 − y1) + x3(y1 − y2)|
     ```
   - Keep track of the **maximum area** found.

2. **Why Shoelace formula?**
   - It’s a direct way to compute the area of a polygon/triangle given its vertices.
   - Avoids using Heron’s formula (which requires square roots and may lead to floating-point issues).

3. **Time Complexity:**
   - We check all triplets of points → `O(n^3)` where `n` is the number of points.
   - Given the constraints (`n ≤ 50`), this is efficient enough.

---

## Dry Run

**Input:**  
points = [[0,0],[0,1],[1,0]]

- Triangle formed: `(0,0), (0,1), (1,0)`  
  Area = `0.5 * |0*(1−0) + 0*(0−0) + 1*(0−1)|`  
  = `0.5 * |0 + 0 − 1| = 0.5`  

Largest area = `0.5`

---

## Code (Java)
```java
class Solution {
    public double largestTriangleArea(int[][] points) {
        double maxArea = 0.0;
        int n = points.length;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                for (int k = j + 1; k < n; ++k) {
                    int x1 = points[i][0], y1 = points[i][1];
                    int x2 = points[j][0], y2 = points[j][1];
                    int x3 = points[k][0], y3 = points[k][1];
                    double area = 0.5 * Math.abs(x1*(y2 - y3) + x2*(y3 - y1) + x3*(y1 - y2));
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }
}
Complexity Analysis

Time Complexity: O(n^3) → checking all triplets.

Space Complexity: O(1) → only using variables for calculation.
Significance

This problem is a good exercise in geometry + brute force iteration.

It reinforces the use of determinants / shoelace formula for computing polygon areas.

Shows that sometimes brute force is acceptable due to small input constraints.
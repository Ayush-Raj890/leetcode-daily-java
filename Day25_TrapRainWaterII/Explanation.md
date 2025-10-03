# Day 25 – Trapping Rain Water II

## Problem Statement
You are given an `m x n` matrix representing an elevation map where `heightMap[i][j]` is the height at position `(i, j)`.  
Your task is to compute the total volume of water that can be trapped after raining.

**LeetCode Problem**: [407. Trapping Rain Water II](https://leetcode.com/problems/trapping-rain-water-ii/)

---

## Example
**Input:**
heightMap = [
[1,4,3,1,3,2],
[3,2,1,3,2,4],
[2,3,3,2,3,1]
]


**Output:**
4

**Explanation:**  
The water is trapped in the "pits" inside the matrix.

---

## Approach
The idea is to update the maximum water level for each cell iteratively:

1. **Initialization:**
   - Copy the original height map into a `vols` array, representing current max water levels.
   - Use two sweeps to update water levels:
     - Forward pass (`top-left → bottom-right`).
     - Backward pass (`bottom-right → top-left`).

2. **Updating Volumes:**
   - For each cell `(i, j)`, update:
     ```
     vols[i][j] = max(heightMap[i][j], min(neighbor constraints))
     ```
   - Keep repeating until no more updates are needed.

3. **Final Calculation:**
   - The trapped water = `Σ(vols[i][j] - heightMap[i][j])` for all inner cells.

---

## Complexity
- **Time Complexity:** `O((m*n) * iterations)` – each pass checks all cells until stable.  
- **Space Complexity:** `O(m*n)` for the `vols` matrix.

---

## Code (Java)
```java
class Solution {
    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length;
        int n = heightMap[0].length;
        int[][] vols = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                vols[i][j] = heightMap[i][j];
            }
        }
        boolean upt = true;
        boolean init = true;

        while (upt) {
            upt = false;
            // Forward pass
            for (int i = 1; i < m - 1; i++) {
                for (int j = 1; j < n - 1; j++) {
                    int val = Math.max(heightMap[i][j],
                             Math.min(vols[i - 1][j], vols[i][j - 1]));
                    if (init || vols[i][j] > val) {
                        vols[i][j] = val;
                        upt = true;
                    }
                }
            }
            init = false;

            // Backward pass
            for (int i = m - 2; i >= 1; i--) {
                for (int j = n - 2; j >= 1; j--) {
                    int val = Math.max(heightMap[i][j],
                             Math.min(vols[i + 1][j], vols[i][j + 1]));
                    if (vols[i][j] > val) {
                        vols[i][j] = val;
                        upt = true;
                    }
                }
            }
        }

        int res = 0;
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (vols[i][j] > heightMap[i][j])
                    res += vols[i][j] - heightMap[i][j];
            }
        }
        return res;
    }
}
Significance

This is a 2D extension of the classic "Trapping Rain Water" problem.

Highlights the importance of multi-pass relaxation or priority queue (heap) approach in grid-based water trapping problems.

Useful for simulations in geographical modeling or flood prediction systems.

# 🔁 Day 67 – Range Addition Queries (2D Difference Array)

## 🧩 Problem Summary
Given an n x n zero matrix and a list of queries [r1, c1, r2, c2], add 1 to every cell inside each inclusive submatrix. Return the final matrix after applying all queries.

## 💡 Key Idea
Use a 2D difference array to apply each rectangular update in O(1): mark the four corners in a (n+1)x(n+1) diff array, then recover the final matrix by computing 2D prefix sums.

## ⚙️ Algorithm
1. Allocate diff array sized (n+1) x (n+1) initialized to 0.
2. For each query (r1,c1,r2,c2):
   - diff[r1][c1] += 1
   - diff[r2+1][c1] -= 1
   - diff[r1][c2+1] -= 1
   - diff[r2+1][c2+1] += 1
3. Build the result matrix mat (n x n) by computing prefix sums:
   - mat[i][j] = diff[i][j] + mat[i-1][j] + mat[i][j-1] - mat[i-1][j-1] (with boundary checks).
4. Return mat.

## ⏱ Complexity
- Time: O(n^2 + q) where q = number of queries (q for updates, n^2 to compute prefix sums).
- Space: O(n^2) for diff and output matrix.

## ✅ Notes
- Using (n+1)x(n+1) diff avoids bounds checks when applying r2+1 / c2+1 markers.
- Works efficiently even when many large-range updates are applied.
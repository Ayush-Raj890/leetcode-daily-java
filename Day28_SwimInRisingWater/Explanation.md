# 🏊‍♂️ Day 28 – Swim in Rising Water (LeetCode 778)

## 🧩 Problem Statement
You are given an `n x n` grid of integers where each value represents the elevation at that cell. Initially, the water level is at `0`, and it rises by `1` every unit of time. You can swim from one cell to another if both cells' elevations are **less than or equal** to the current water level.

Return the **minimum time** required to reach the bottom-right cell `(n-1, n-1)` from the top-left cell `(0, 0)`.

---

## 💡 Example
### Input:
grid = [
[0, 2],
[1, 3]
]

### Output:
3

### Explanation:
At time `3`, the water level is high enough to reach all cells.

---

## 🧠 Approach
1. **Binary Search on Time**:  
   - We try to find the minimum time `t` such that it’s possible to reach `(n-1, n-1)` when the water level is `t`.

2. **DFS Check**:  
   - For each time `t`, we perform a DFS/BFS to verify if we can reach the end while staying under water level `t`.

3. **Search Space**:  
   - The range is from `grid[0][0]` to the maximum height in the grid.

---

## 🧮 Dry Run
For `grid = [[0,2],[1,3]]`:
- `lo = 0`, `hi = 3`
- `mid = 1 →` cannot reach end
- `mid = 2 →` cannot reach end
- `mid = 3 →` can reach end ✅  
Hence, answer = **3**

---

## ⏱️ Complexity
| Type | Complexity |
|------|-------------|
| Time | O(n² * log(maxHeight)) |
| Space | O(n²) |

---

## 🎯 Significance
This problem combines **binary search on the answer** and **graph traversal (DFS)** — a common technique in advanced grid problems.

---

## ✅ Code
```java
class Solution {
    public int swimInWater(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] directions = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        
        int lo = grid[0][0], hi = 0;
        for (int[] row : grid)
            for (int val : row)
                hi = Math.max(hi, val);
        
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (possible(grid, mid, m, n, directions)) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }
    
    private boolean possible(int[][] grid, int mid, int m, int n, int[][] directions) {
        if (grid[0][0] > mid) return false;
        boolean[][] seen = new boolean[m][n];
        return dfs(grid, 0, 0, mid, seen, m, n, directions);
    }
    
    private boolean dfs(int[][] grid, int r, int c, int mid, boolean[][] seen, int m, int n, int[][] directions) {
        if (r == m-1 && c == n-1) return true;
        seen[r][c] = true;
        
        for (int[] dir : directions) {
            int nr = r + dir[0], nc = c + dir[1];
            if (nr >= 0 && nr < m && nc >= 0 && nc < n && !seen[nr][nc]) {
                if (grid[nr][nc] <= mid) {
                    if (dfs(grid, nr, nc, mid, seen, m, n, directions)) return true;
                }
            }
        }
        return false;
    }
}
## 📊 Visualization

You can add a diagram in the `assets/` folder to show how the water level rises and the path taken.

---

## 📝 Notes

- BFS can be used instead of DFS for reachability.
- For optimal performance, a priority queue (Dijkstra's algorithm) is also a common solution.

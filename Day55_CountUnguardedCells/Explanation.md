# 🛡️ Day 55 – Count Unguarded Cells

## 🧩 Problem Statement

Given an `m x n` grid, positions of `guards` and `walls`, determine how many cells are not guarded.  
A guard watches in the four cardinal directions (up, down, left, right) until a wall or another guard blocks the view. Return the number of cells that remain unguarded and are not walls/guards.

LeetCode: 2257. Count Unguarded Cells in the Grid

---

## 💡 Key Idea

- Mark all guard and wall positions as blocked.
- For each guard, cast rays in four directions and mark all cells along each ray as guarded until a wall or guard is encountered.
- Count cells that remain unmarked (neither guard, wall, nor guarded).

---

## ✅ Algorithm (high level)

1. Build a set/map of blocked positions (guards + walls) for O(1) checks.
2. Maintain a 2D visited/guarded matrix.
3. For each guard, run directional DFS/iteration along each of the four directions:
   - Stop when going out of bounds or hitting a blocked cell.
   - Mark traversed cells as guarded.
4. After processing all guards, count cells with visited == 0.

---

## 🧾 Example

Input:
- m = 4, n = 6  
- guards = [[0,0],[1,1],[2,3]]  
- walls = [[0,1],[1,3]]

Output:
- number of unguarded cells (depends on input)

---

## ⏱️ Complexity

- Time: O(m * n + g + w) — each cell is visited at most a constant number of times by directional scans; g = number of guards, w = number of walls.
- Space: O(m * n) for the visited array and O(g + w) for the blocked set.

---

## 🔎 Notes

- Use a HashSet (or map) keyed by "r,c" for blocked checks to simplify bounds/containment logic.
- Directional scanning (iterative or recursive with early exit) is more efficient than BFS here because rays stop at first blocker.
- Be careful to mark guards and walls as visited so they are not counted as unguarded.

---

## 📌 Code Reference

See `Solution.java` in this folder for the implementation (directional DFS scans and marking logic).
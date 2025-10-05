# Day 27 – Pacific Atlantic Water Flow 🌊

### Problem Statement  
Given an `m x n` matrix `heights`, where each cell represents the height of the land.  
Water can flow from a cell to another cell if the next cell’s height is **less than or equal** to the current one and they are adjacent (up, down, left, right).

- The **Pacific Ocean** touches the **top** and **left** edges.  
- The **Atlantic Ocean** touches the **bottom** and **right** edges.  

Return all grid coordinates `[i, j]` from which water can flow to **both oceans**.

---

### Example  
**Input:**  
heights = [
[1,2,2,3,5],
[3,2,3,4,4],
[2,4,5,3,1],
[6,7,1,4,5],
[5,1,1,2,4]
]

**Output:**  

[[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]


---

### 🔍 Approach  
1. Use **DFS (Depth First Search)** to explore cells that can reach each ocean.  
2. Start DFS from all **Pacific edges** (top and left borders).  
3. Start DFS from all **Atlantic edges** (bottom and right borders).  
4. Maintain two boolean matrices — one for Pacific and one for Atlantic reachability.  
5. Any cell marked `true` in **both matrices** can flow to both oceans.  
6. Collect all such cells and return them as the final answer.

---

### 🧩 Dry Run Example  
For grid:  
1 2
4 3
- Pacific starts from (0,0), (1,0)  
- Atlantic starts from (0,1), (1,1)  
- Common reachable cells: **[(0,1), (1,0), (1,1)]**

---

### ⏱️ Complexity  
- **Time Complexity:** O(m × n) — each cell visited at most twice  
- **Space Complexity:** O(m × n) — for visited matrices and recursion stack  

---

### 💡 Significance  
- Classic example of **multi-source DFS/BFS** starting from the edges instead of the source.  
- Reinforces understanding of **grid traversal** and **reverse flow problems**.
day: 27
title: Pacific Atlantic Water Flow
leetcode_number: 417
difficulty: Medium
language: Java
topics:
  - Depth-First Search
  - Breadth-First Search
  - Matrix
  - Graph
time_complexity: O(m * n)
space_complexity: O(m * n)
description: >
  Given an m x n matrix heights, return all coordinates where water can flow to both
  the Pacific and Atlantic oceans using DFS traversal from the borders.
approach: >
  Perform DFS from all Pacific and Atlantic border cells to mark reachable cells.
  Any cell reachable from both oceans is part of the final result.
example:
  input: |
    heights = [
      [1,2,2,3,5],
      [3,2,3,4,4],
      [2,4,5,3,1],
      [6,7,1,4,5],
      [5,1,1,2,4]
    ]
  output: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
significance: >
  Demonstrates a reverse search approach from multiple sources, useful in water flow
  or flood fill style problems.


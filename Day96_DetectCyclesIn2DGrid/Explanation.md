# 1559. Detect Cycles in 2D Grid

## Approach

Treat each cell as a node in an undirected graph where edges connect adjacent cells (up, down, left, right) having the same character.

Use DFS from every unvisited cell:
- Mark the current cell as visited.
- Explore only neighbors with the same character.
- Track the parent cell `(pr, pc)` to avoid counting the immediate back edge.
- If we reach an already visited same-character neighbor that is not the parent, a cycle exists.

## Complexity

- Time: O(m * n)
- Space: O(m * n)

`m` = number of rows, `n` = number of columns.

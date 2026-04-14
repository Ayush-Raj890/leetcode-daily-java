# Day 84 - Minimum Total Distance Traveled

**Problem Link:** LeetCode #2463: Minimum Total Distance Traveled

---

## Problem Statement
You are given positions of robots and factories.
Each factory has a position and a repair limit (how many robots it can repair).
Assign every robot to a factory such that no factory exceeds its limit,
and the sum of traveled distances is minimum.

---

## Approach (Sorting + Dynamic Programming)
1. Sort robots by position.
2. Sort factories by position.
3. Let `dp[i][j]` be the minimum distance to repair first `i` robots using first `j` factories.

Transition for factory `j`:
- Option 1: Skip this factory: `dp[i][j] = dp[i][j - 1]`
- Option 2: Assign `k` robots (where `1 <= k <= limit`) ending at robot `i - 1` to factory `j`.
  Accumulate distance incrementally and update:
  `dp[i][j] = min(dp[i][j], dp[i - k][j - 1] + dist)`

Base case:
- `dp[0][j] = 0` for all `j`

Answer:
- `dp[n][m]`

---

## Why This Works
Sorting ensures robots and factories are processed in positional order,
which matches optimal contiguous assignments when using capacities.
For each factory, the DP tries all valid counts of robots repaired by that factory,
combined with the best previous state. This explores all feasible assignments and keeps the minimum total distance.

---

## Time and Space Complexity
Let:
- `n` = number of robots
- `m` = number of factories
- `L` = average/maximum factory limit considered per state

- **Time Complexity:** `O(n * m * L)`
- **Space Complexity:** `O(n * m)`

---

## Java Solution
See [Solution.java](Solution.java).

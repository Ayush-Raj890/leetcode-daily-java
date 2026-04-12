# Day 82 - Minimum Distance to Type a Word Using Two Fingers

**Problem Link:** LeetCode #1320: Minimum Distance to Type a Word Using Two Fingers

---

## Problem Statement
You need to type an uppercase word on a keyboard laid out in 6 columns using two fingers.
Moving a finger from character `a` to `b` costs Manhattan distance on this grid.
Find the minimum total movement needed to type the full word.

---

## Approach (3D Dynamic Programming)
Let:
- `dp[i][l][r]` = minimum cost after typing first `i` characters,
  where left finger is on letter `l` and right finger is on letter `r`.

For the next target letter `t = word.charAt(i) - 'A'`, we transition from every state:
1. Move right finger to `t`:
   `dp[i+1][l][t] = min(dp[i+1][l][t], dp[i][l][r] + dist(r, t))`
2. Move left finger to `t`:
   `dp[i+1][t][r] = min(dp[i+1][t][r], dp[i][l][r] + dist(l, t))`

Distance is Manhattan distance on a `6`-column layout:
- row = `x / 6`
- col = `x % 6`

The answer is the minimum value among all `dp[n][l][r]`.

---

## Why This Works
At each character, exactly one finger presses it.
The DP enumerates both choices from every valid previous finger-position state, so it explores all possible typing sequences and keeps only the best cost for each state.
Therefore, the final minimum over all ending finger positions is optimal.

---

## Time and Space Complexity
- **Time Complexity:** `O(n * 26 * 26)`
- **Space Complexity:** `O(n * 26 * 26)`

---

## Java Solution
See [Solution.java](Solution.java).

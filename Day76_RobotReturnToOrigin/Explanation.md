# Day 76 - Robot Return to Origin

**Problem Link:** [LeetCode #657: Robot Return to Origin](https://leetcode.com/problems/robot-return-to-origin/)

---

## Problem Statement
A robot starts at the origin `(0, 0)` on a 2D plane. You are given a string `moves` containing the directions `U`, `D`, `L`, and `R`.

Return `true` if the robot returns to the origin after performing all moves, otherwise return `false`.

---

## Approach
This solution tracks the robot's position with two variables:

1. **Initialize position:**
   Start at `x = 0` and `y = 0`.

2. **Process each move:**
   - `U` decreases `y`
   - `D` increases `y`
   - `L` decreases `x`
   - `R` increases `x`

3. **Check final position:**
   If both `x` and `y` are `0`, the robot is back at the origin.

---

## Why This Works
- Each move changes the robot's coordinates by exactly one unit.
- The robot returns to the origin only when horizontal and vertical displacements cancel out.
- Tracking net movement is enough; we do not need to simulate the full path.

---

## Time and Space Complexity
- **Time Complexity:** `O(n)`
  - Each character in `moves` is processed once.
- **Space Complexity:** `O(1)`
  - Only two integer variables are used.

---

## Java Solution
```java
class Solution {
    public boolean judgeCircle(String moves) {
        int x = 0, y = 0;
        for (char move : moves.toCharArray()) {
            if (move == 'U') y--;
            else if (move == 'D') y++;
            else if (move == 'L') x--;
            else if (move == 'R') x++;
        }
        return x == 0 && y == 0;
    }
}
```

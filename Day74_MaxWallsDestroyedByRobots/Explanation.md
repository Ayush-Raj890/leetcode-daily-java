# Day 74 – Maximum Walls Destroyed by Robots

**Problem Link:** [LeetCode #3661: Maximum Walls Destroyed by Robots](https://leetcode.com/problems/maximum-walls-destroyed-by-robots/)

---

## Problem Statement
Given an array of robot positions, their shooting distances, and wall positions, determine the maximum number of walls that can be destroyed. Robots can shoot left or right, but their shooting ranges cannot overlap with each other's positions.

---

## Approach
This solution uses **dynamic programming with two-pointer technique**:

1. **Record Structure:** Create a `Robot` record to pair each position with its distance.

2. **Sorting:** Sort robots by position and walls in ascending order.

3. **Three Phase Preparation:**
   - **prepareLeftWall():** For each robot, count walls in range `[max(prev_pos+1, pos-dist), pos]` (shooting left).
   - **prepareRightWall():** For each robot, count walls in range `[pos, min(next_pos-1, pos+dist)]` (shooting right).
   - **prepareCommon():** Count overlapping walls between adjacent robots' ranges that can be shot by either.

4. **Dynamic Programming:**
   - `dpLeft[i]`: Maximum walls destroyed from robots 0 to i, with robot i shooting left.
   - `dpRight[i]`: Maximum walls destroyed from robots 0 to i, with robot i shooting right.
   - Transition: 
     - `dpLeft[i] = leftWall[i] + max(dpLeft[i-1], dpRight[i-1] - common[i])`
     - `dpRight[i] = rightWall[i] + max(dpLeft[i-1], dpRight[i-1])`

5. **Result:** Return the maximum of the last state values.

---

## Key Insights
- **Two-pointer optimization:** Efficiently track wall boundaries for each robot without rescanning.
- **Overlap handling:** The `common` array prevents counting the same wall twice when transitioning between states.
- **Adjacency constraint:** Only adjacent robots can have overlapping shooting ranges.

---

## Time & Space Complexity
- **Time Complexity:** O(n log n + m log m + n + m) where n is robot count and m is wall count → **O((n+m) log(n+m))**
- **Space Complexity:** O(n + m) for arrays and robot records

---

## Significance
- Demonstrates **interval-based dynamic programming** with constraint management.
- Shows optimization of naive range-counting solutions using two-pointer technique.
- Illustrates careful state transition handling to avoid double-counting overlapping ranges.

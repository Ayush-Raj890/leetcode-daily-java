# Day 23 – Water Bottles

**Problem Link:** [LeetCode #1518: Water Bottles](https://leetcode.com/problems/water-bottles/)

---

## Problem Statement
You have `numBottles` full water bottles. You can exchange `numExchange` empty bottles for one full bottle of water.  
Each time you drink a full bottle, it becomes empty.  

Return the maximum number of bottles of water you can drink.

---

## Approach
- Start with `numBottles` full bottles. Initialize `count` with `numBottles` (total bottles drunk so far).  
- While you have at least `numExchange` empty bottles:
  1. Exchange them for new full bottles (`newBottle = numBottles / numExchange`).  
  2. Add these new bottles to the count.  
  3. Update `numBottles` to include the remaining empty bottles plus the newly gained full bottles.  
- Continue until you cannot exchange anymore.  
- Return `count`.

---

## Dry Run
**Input:** `numBottles = 9, numExchange = 3`  

- Start: count = 9  
- Exchange: 9 / 3 = 3 → drink 3 more → count = 12 → remaining = 3 + 0 = 3  
- Exchange: 3 / 3 = 1 → drink 1 more → count = 13 → remaining = 1 + 0 = 1  
- No more exchanges possible.  

**Output:** `13`

---

## Time & Space Complexity
- **Time Complexity:** O(n / k) → where `n` = numBottles and `k` = numExchange, since each exchange reduces bottles.  
- **Space Complexity:** O(1) → only a few variables are used.  

---

## Significance
- Classic simulation problem.  
- Reinforces **loop invariants** and updating state with multiple variables.  
- Useful practice for resource exchange or **greedy consumption** style problems.

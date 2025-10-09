# 🚗 Day 31 – Minimum Time to Repair Cars

## 🧩 Problem Statement

Given two arrays:
- `skill[]`: The skill level of each mechanic.
- `mana[]`: The mana (energy) available for each repair session.

Each mechanic can repair cars in multiple sessions, and the time taken for each repair depends on both the mechanic's skill and the session's mana.  
The goal is to find the **minimum total time required to repair all cars**.

---

## 💡 Example

**Input:**  
`skill = [2, 3]`  
`mana = [5, 4]`

**Output:**  
`34`

**Explanation:**  
The mechanics repair cars in sessions, and the total time is calculated based on the product of skill and mana for each session and mechanic.

---

## 🧠 Approach

This solution uses **dynamic programming** with two passes for each session:

1. **Forward Pass:**  
   - For each session, update the minimum time for repairing up to each car.
   - For each mechanic, calculate the time to repair the next car using the current session's mana and the mechanic's skill.
   - Update `done[i + 1]` to be the maximum of its current value and `done[i]`, then add the time for the current car.

2. **Backward Pass:**  
   - Adjust the time for each mechanic to ensure the minimum time is maintained for subsequent sessions.
   - For each mechanic (from last to first), update `done[i]` based on the next mechanic's time minus the time for the current car.

3. **Result:**  
   - After all sessions, `done[n]` contains the minimum total time required to repair all cars.

---

## ⏱️ Complexity

| Type | Complexity |
|------|------------|
| Time | O(n * m)   |
| Space| O(n)       |

---

## ✅ Code Reference

See `Solution.java` for the implementation.

---

## 📝 Notes

- The two-pass update (forward and backward) ensures that the minimum time is calculated by considering all possible repair sequences.
- This approach is efficient and avoids redundant calculations.

---
# 🌧️ Day 29 – Avoid Flood in the City (LeetCode 1488)

## 🧩 Problem Statement

You are given an array `rain` where `rain[i]` is the lake that gets rain on day `i` (or `0` if it's a dry day).  
If a lake is rained on twice without being dried in between, the city floods.  
On dry days (`rain[i] == 0`), you can choose any lake to dry.  
Return an array indicating which lake to dry on each dry day (or `-1` for rain days).  
If it's impossible to avoid flooding, return an empty array.

---

## 💡 Example

**Input:**  
`rain = [1,2,0,0,2,1]`

**Output:**  
`[-1,-1,2,1,-1,-1]`

**Explanation:**  
- Day 0: Lake 1 rains, mark as full.
- Day 1: Lake 2 rains, mark as full.
- Day 2: Dry lake 2.
- Day 3: Dry lake 1.
- Day 4: Lake 2 rains again (safe, was dried).
- Day 5: Lake 1 rains again (safe, was dried).

---

## 🧠 Approach

We use a **Union-Find (Disjoint Set)** data structure to efficiently track available dry days and assign them to lakes that need drying:

1. **Initialization:**
   - `res`: Result array, filled with `1` for dry days, `-1` for rain days.
   - `map`: Tracks the last day each lake was filled.
   - `UnionFind`: Helps find the next available dry day after a lake was last filled.

2. **Processing Days:**
   - For each day:
     - If it's a rain day (`rain[i] > 0`):
       - Mark `res[i] = -1`.
       - If the lake was filled before, find the next available dry day after its last fill using Union-Find.
       - If no such dry day exists before the current rain, flooding is unavoidable; return an empty array.
       - Assign that dry day to dry the lake (`res[dry] = lake`).
       - Update Union-Find to mark the dry day as used.
       - Update the last fill day for the lake.
     - If it's a dry day (`rain[i] == 0`), leave `res[i] = 1` (will be replaced if needed).

3. **Union-Find Details:**
   - `find(i)`: Finds the next available dry day after day `i`.
   - `unite(i)`: Marks day `i` as used by linking it to the next available day.

---

## ⏱️ Complexity

| Type | Complexity |
|------|-------------|
| Time | O(n log n) |
| Space | O(n) |

---

## 🎯 Significance

- Efficiently matches dry days to lakes that need drying.
- Avoids brute-force search for dry days using Union-Find.
- Handles edge cases where flooding is unavoidable.

---

## ✅ Code Reference

See `Solution.java` for the implementation using Union-Find.

---

## 📝 Notes

- The Union-Find trick is key for efficiently finding the next available dry day.
- If you can't dry a lake before it rains again, return an empty array.
- On dry days not needed for urgent drying, any lake can be dried (default to `1`).

---
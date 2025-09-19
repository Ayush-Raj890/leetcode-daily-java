# Day 11 – Design Spreadsheet

**Problem Link:** [LeetCode - Design Spreadsheet](https://leetcode.com/problems/design-spreadsheet/) :contentReference[oaicite:0]{index=0}

---

## Problem Statement  
Design a simple spreadsheet system with these operations:  
- `Spreadsheet(int rows)` – initialize spreadsheet.  
- `setCell(String cell, int value)` – sets a cell to a given value.  
- `resetCell(String cell)` – resets a cell (makes its value go back to default).  
- `getValue(String formula)` – formula will be in the form `=X+Y`, where X and Y are either integer constants or references to cells. If a cell is not explicitly set, its value is treated as `0`.

---

## Example  

Spreadsheet spreadsheet = new Spreadsheet(3);

spreadsheet.setCell("A1", 5);
spreadsheet.setCell("B1", 3);
int val = spreadsheet.getValue("=A1+B1"); // returns 8

spreadsheet.resetCell("A1");
val = spreadsheet.getValue("=A1+10"); // returns 10 (A1 treated as 0)

---

## Approach  

1. We store non-default cells in a `Map<String, Integer> cells`, where the key is the cell identifier (like `"A1"`) and the value is the integer stored.  
2. **For `setCell(cell, value)`** – we put/update that key-value in the map.  
3. **For `resetCell(cell)`** – we remove the entry from the map, so it reverts to default implicit zero.  
4. **For `getValue(formula)`** –  
   - Remove the leading `"="`.  
   - Split by `"+"`.  
   - For each part:
     - If it’s a number → parse it.  
     - Otherwise it’s a cell reference → lookup in `cells` map, default to `0` if absent.  
   - Sum both parts and return.

---

## Dry Run  

- Call: `setCell("A1", 5)` → map becomes `{ "A1" -> 5 }`  
- Call: `setCell("B1", 3)` → map is `{ "A1" -> 5, "B1" -> 3 }`  
- Call: `getValue("=A1+B1")` → parts `"A1"` and `"B1"` → both present → `5 + 3 = 8`  
- Call: `resetCell("A1")` → remove `"A1"` → map becomes `{ "B1" -> 3 }`  
- Call: `getValue("=A1+10")` → parts `"A1"` (not in map ⇒ 0) and `"10"` ⇒ `0 + 10 = 10`

---

## Time & Space Complexity  

- **Time Complexity:**  
  - `setCell` and `resetCell` → O(1) average (hash map).  
  - `getValue` → O(1) for splitting plus lookup for each part → constant time parts, so overall O(1).  

- **Space Complexity:**  
  - O(N) where N = number of cells that have been explicitly set (non-default).  

---

## Significance  

- Teaches basic design of a stateful component (spreadsheet) using a map to store sparse data.  
- Illustrates formula parsing, default value behavior, and string splitting.  
- Good for understanding how to handle different input types (constants vs references) and fallback/default logic.

---

✅ This completes **Day 11 – Design Spreadsheet**  

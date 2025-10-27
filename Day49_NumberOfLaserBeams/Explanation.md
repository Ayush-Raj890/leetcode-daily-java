# 🔦 Day 49 – Number of Laser Beams in a Bank

## 🧩 Problem Statement

Anti-theft security devices are activated inside a bank. You are given a `m x n` binary matrix `bank` representing the floor plan of the bank. Each cell is either `'0'` (empty) or `'1'` (security device).

A laser beam is formed between two security devices if:
- They are in **different rows**.
- There are **no security devices** in the rows between them.

Return the **total number of laser beams** in the bank.

**LeetCode Problem**: [2125. Number of Laser Beams in a Bank](https://leetcode.com/problems/number-of-laser-beams-in-a-bank/)

---

## 💡 Examples

### Example 1:
**Input:**  
```
bank = ["011001","000000","010100","001000"]
```

**Output:**  
`8`

**Explanation:**  
- Row 0 has 3 devices
- Row 1 has 0 devices (skip)
- Row 2 has 2 devices → beams = 3 × 2 = 6
- Row 3 has 1 device → beams = 2 × 1 = 2
- **Total**: 6 + 2 = 8

### Example 2:
**Input:**  
```
bank = ["000","111","000"]
```

**Output:**  
`0`

**Explanation:**  
No laser beams because there's only one row with devices.

---

## 🧠 Approach

This solution uses a **single-pass counting approach**:

1. **Count Devices Per Row:**
   - For each row, count the number of security devices (`'1'`).

2. **Calculate Beams:**
   - Laser beams connect consecutive non-empty rows.
   - If the current row has `dev` devices and the previous row had `prev` devices, add `dev × prev` beams.

3. **Skip Empty Rows:**
   - Only update `prev` when the current row has devices.
   - Empty rows don't affect the beam count.

4. **Track Previous Count:**
   - Maintain `prev` to store the device count of the last non-empty row.

---

## 📊 Algorithm Steps

1. Initialize `ans = 0` (total beams) and `prev = 0` (devices in previous non-empty row).

2. For each row in `bank`:
   - Count devices in the current row (`dev`).
   - If `dev > 0`:
     - Add `dev × prev` to `ans` (beams between current and previous row).
     - Update `prev = dev`.

3. Return `ans`.

---

## 🔍 Example Walkthrough

**Input:** `bank = ["011001","000000","010100","001000"]`

| Row | Devices (dev) | Previous (prev) | Beams Added | Total Beams |
|-----|---------------|-----------------|-------------|-------------|
| 0   | 3             | 0               | 3 × 0 = 0   | 0           |
| 1   | 0             | 3               | (skip)      | 0           |
| 2   | 2             | 3               | 2 × 3 = 6   | 6           |
| 3   | 1             | 2               | 1 × 2 = 2   | 8           |

**Output:** `8`

---

## ⏱️ Complexity

| Type  | Complexity |
|-------|------------|
| Time  | O(m × n)   |
| Space | O(1)       |

Where:
- `m` = number of rows
- `n` = number of columns

---

## ✅ Code Reference

See `Solution.java` for the implementation.

---

## 🎯 Key Insights

- **Only non-empty rows matter**: Empty rows are skipped without affecting the count.
- **Multiplication principle**: Beams between two rows = (devices in row A) × (devices in row B).
- **One-pass solution**: No need to store all row counts, just track the previous non-empty row.
- **Efficient**: Constant space and linear time.

---

## 📝 Notes

- The first row with devices creates no beams (no previous row).
- Consecutive empty rows are effectively ignored.
- The problem tests understanding of combinatorial counting.

---

## 💡 Edge Cases

- All rows are empty → `0` beams
- Only one row has devices → `0` beams
- All devices in one row → `0` beams
- Alternating empty and device rows → calculate beams between non-empty rows

---
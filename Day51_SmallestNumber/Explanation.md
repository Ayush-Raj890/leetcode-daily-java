# 🔢 Day 51 – Smallest Number

## 🧩 Problem Statement

Given an integer `n`, find the smallest integer `x` such that `x >= n` and `x` is a number where all bits are set to 1 (i.e., `x` is of the form 2^k - 1).

In other words, find the smallest number greater than or equal to `n` that has all bits set to 1 in its binary representation.

---

## 💡 Examples

### Example 1:
**Input:**  
`n = 5`

**Output:**  
`7`

**Explanation:**  
- 5 in binary: `101`
- 7 in binary: `111` (all bits set to 1)
- 7 >= 5 and has all bits set

### Example 2:
**Input:**  
`n = 10`

**Output:**  
`15`

**Explanation:**  
- 10 in binary: `1010`
- 15 in binary: `1111` (all bits set to 1)
- 15 >= 10 and has all bits set

### Example 3:
**Input:**  
`n = 3`

**Output:**  
`3`

**Explanation:**  
- 3 in binary: `11` (already all bits set to 1)
- Return 3 itself

---

## 🧠 Approach

This solution uses a **bit manipulation trick**:

1. **Key Insight:**
   - A number with all bits set to 1 has the form: `2^k - 1` (e.g., 1, 3, 7, 15, 31, 63...)
   - For such numbers: `x & (x + 1) == 0`
   - Example: 7 & 8 = `0111 & 1000 = 0000`

2. **Algorithm:**
   - Start with `x = n`
   - While `(x & (x + 1)) != 0`:
     - Increment `x`
   - Return `x`

3. **Why This Works:**
   - When all bits are 1, adding 1 creates a power of 2 (single bit set)
   - AND operation between them gives 0
   - We keep incrementing until we find such a number

---

## 📊 Bit Pattern Analysis

| Number | Binary | x & (x+1) | All Bits Set? |
|--------|--------|-----------|---------------|
| 5      | 0101   | 0100      | No            |
| 6      | 0110   | 0110      | No            |
| 7      | 0111   | 0000      | Yes ✓         |
| 10     | 1010   | 1010      | No            |
| 15     | 1111   | 0000      | Yes ✓         |

---

## ⏱️ Complexity

| Type  | Complexity |
|-------|------------|
| Time  | O(log n)   |
| Space | O(1)       |

**Explanation:**
- In the worst case, we increment at most `2^k - n` times where `k` is the number of bits in `n`
- This is bounded by the number of bits needed to represent `n`

---

## ✅ Code Reference

See `Solution.java` for the implementation.

---

## 🎯 Key Insights

- **Bit manipulation property**: Numbers with all bits set have `x & (x+1) = 0`
- **Forms**: 1, 3, 7, 15, 31, 63, 127, 255... (all of form 2^k - 1)
- **Efficient check**: Single bitwise AND operation per iteration
- **Simple loop**: Increment until condition is met

---

## 📝 Notes

- The solution finds the next "all ones" number in binary
- These numbers are also known as Mersenne numbers (when prime)
- The approach is elegant using bit manipulation instead of mathematical formulas

---

## 💡 Alternative Approaches

### Method 1: Mathematical Formula
```java
public int smallestNumber(int n) {
    int bits = Integer.toBinaryString(n).length();
    return (1 << bits) - 1;
}
```
- Find number of bits in `n`
- Return `2^bits - 1`
- Time: O(log n), Space: O(1)

### Method 2: Bit Filling
```java
public int smallestNumber(int n) {
    int x = n;
    x |= x >> 1;
    x |= x >> 2;
    x |= x >> 4;
    x |= x >> 8;
    x |= x >> 16;
    return x;
}
```
- Fill all bits to the right of the most significant bit
- Time: O(1), Space: O(1)

---

## 🔍 Edge Cases

- `n = 1` → `1` (already all bits set)
- `n = 0` → `0` (edge case, depending on problem constraints)
- Large values of `n` → Still efficient due to logarithmic complexity

---
# 🔢 Day 45 – Has Same Digits

## 🧩 Problem Statement

Given a string `s` containing digits, determine if the string satisfies a specific digit property.  
The problem checks if two weighted sums (left and right) computed using binomial coefficients are equal modulo 10.

---

## 💡 Example

**Input:**  
`s = "1234"`

**Output:**  
`true` or `false`

**Explanation:**  
The algorithm computes weighted sums from both ends of the string using combinatorial coefficients and checks if they match modulo 10.

---

## 🧠 Approach

This solution uses **advanced number theory** to efficiently compute binomial coefficients modulo 10:

1. **Weighted Sum Calculation:**
   - For each digit in the string, compute two weighted sums:
     - `left`: Sum using binomial coefficients C(n-1, i)
     - `right`: Sum using binomial coefficients C(n-1, i-1)
   - Both sums are computed modulo 10

2. **Efficient Binomial Coefficient Computation:**
   - Uses **Chinese Remainder Theorem (CRT)** to compute C(n, k) mod 10
   - Since 10 = 2 × 5, we compute:
     - C(n, k) mod 2
     - C(n, k) mod 5
   - Then combine them to get C(n, k) mod 10

3. **Lucas' Theorem for mod 5:**
   - Uses the `fast5` lookup table to compute binomial coefficients mod 5 efficiently
   - Applies Lucas' theorem: C(n, k) mod p = ∏ C(n_i, k_i) mod p

4. **Binary Check for mod 2:**
   - Uses bitwise operations to check if C(n, k) is odd or even
   - C(n, k) is odd iff all bits in k are subset of bits in n

5. **Combination:**
   - Uses the `xunzhi` lookup table to combine mod 2 and mod 5 results

---

## 📊 Algorithm Details

### Helper Function: `getMod10(n, i)`

Computes C(n, i) mod 10 using:

**Lookup Tables:**
- `fast5[a][b]`: Precomputed C(a, b) mod 5 for a, b ∈ [0, 4]
- `xunzhi[mod2][mod5]`: Maps (mod 2, mod 5) → mod 10

**Steps:**
1. Compute `mod2` using binary representation
2. Compute `mod5` using base-5 representation with Lucas' theorem
3. Combine using `xunzhi` table

---

## ⏱️ Complexity

| Type  | Complexity  |
|-------|-------------|
| Time  | O(n log n)  |
| Space | O(1)        |

---

## ✅ Code Reference

See `Solution.java` for the implementation.

---

## 🎯 Significance

- Demonstrates efficient computation of binomial coefficients using number theory
- Uses **Chinese Remainder Theorem** and **Lucas' Theorem**
- Avoids expensive factorial computations
- Optimal for problems requiring modular arithmetic on combinatorial values

---

## 📝 Notes

- The solution is mathematically elegant and highly optimized
- The lookup tables make it O(1) for small values
- This approach is much faster than naive binomial computation O(n²)
- Useful for competitive programming and mathematical problems

---
# Day 79 - Xor After Queries

---

## Problem Statement
Given an array `nums`, each query is `[l, r, k, v]`.
For every index `i` in the arithmetic progression `l, l + k, l + 2k, ... <= r`, multiply:

- `nums[i] = nums[i] * v (mod 1e9+7)`

After applying all queries, return the XOR of all values in `nums`.

---

## Approach
A direct simulation can be too slow when many queries have small step size `k`.

We split queries by step size using sqrt decomposition:

1. Let `T = floor(sqrt(n))`.
2. For large step (`k >= T`): process directly because each query touches few elements.
3. For small step (`k < T`): group queries by `k` and process each group in batch.

For each fixed small `k`:

1. Use a multiplicative difference-like array `dif` initialized with 1.
2. For query `[l, r, k, v]`:
   - multiply `dif[l]` by `v`
   - multiply `dif[R]` by `v^{-1}` where `R` is first position after last affected term
3. Prefix-propagate with jump `k`:
   - `dif[i] *= dif[i-k]`
4. Multiply `nums[i]` by accumulated `dif[i]`.

Mod inverse is computed by fast power:

- `v^{-1} = v^(MOD-2) mod MOD` (Fermat's little theorem).

---

## Why This Works
- Large `k` queries are cheap individually.
- Small `k` queries are expensive individually, so batching by fixed `k` avoids repeated updates.
- The multiplicative difference trick ensures each query contributes exactly on its arithmetic progression range.
- Combining all groups applies exactly the same final multipliers as naive simulation.

---

## Time and Space Complexity
- Let `n = nums.length`, `q = queries.length`, `T = sqrt(n)`.
- Large-step queries cost about `O(q * n / T)` in total.
- Small-step groups cost about `O(T * n + q)`.
- Practical total is near `O(n * sqrt(n) + q * sqrt(n))` depending on distribution.
- Space: `O(n + T)`.

---

## Java Solution
See [Solution.java](Solution.java).

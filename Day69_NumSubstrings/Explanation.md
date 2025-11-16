# 🔢 Day 69 – Number of Substrings (count of all-1 substrings)

## 🧩 Problem
Count the number of substrings consisting entirely of `'1'` in a binary string `s`. Return the result modulo 1e9+7.

## 💡 Key idea
- Each consecutive run of `1`s of length L contributes L*(L+1)/2 substrings.
- The provided solution accumulates a running count `cnt` of consecutive `1`s and adds `cnt` to `total` at each step (equivalent to summing L down to 1 for each run).
- Use long and take modulo 1_000_000_007 to avoid overflow.

## Complexity
- Time: O(n)
- Space: O(1)

## Example
s = "11101" → runs: 3 and 1 → substrings = 3*4/2 + 1*2/2 = 6 + 1 = 7.

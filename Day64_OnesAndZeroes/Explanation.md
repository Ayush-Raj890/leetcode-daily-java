# 🔢 Day 64 – Ones and Zeroes

## 🧩 Problem Summary
Given an array of binary strings `S` and integers `M` and `N`, find the maximum number of strings you can pick from `S` such that the total number of zeros used is at most `M` and the total number of ones used is at most `N`. Each string consumes its count of zeros and ones once.

## 💡 Key Idea
This is a 0/1 knapsack variant with two resource constraints (zeros and ones). Use a 2D DP where dp[i][j] = maximum number of strings achievable using at most i zeros and j ones. Process each string once and update dp in reverse (to preserve the 0/1 property).

## ✅ Algorithm
- For each string, count zeros and ones.
- For i from M down to zeros:
  - For j from N down to ones:
    - dp[i][j] = max(dp[i][j], dp[i - zeros][j - ones] + 1)
- Answer is dp[M][N].

## ⏱ Complexity
- Time: O(S_len * M * N) where S_len = number of strings.
- Space: O(M * N) for DP table.

## 🔢 Example
S = ["10","0001","111001","1","0"], M = 5, N = 3 → output = 4

## 📝 Notes
- Reverse iteration ensures each string is used at most once.
- Works efficiently for moderate M, N (constraints on LeetCode).
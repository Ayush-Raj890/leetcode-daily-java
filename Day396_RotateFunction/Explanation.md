# Day 396 — Rotate Function (LeetCode 396)

Problem: Given an integer array A of length n, define F(k) as the sum of i * B[i] where B is A rotated k times. Return the maximum F(k) over all k.

Approach:
- Compute the total sum of array elements `sum` and the initial rotation function value `F(0)`.
- Use the recurrence: F(k) = F(k-1) + sum - n * A[n-k]
- Iterate k = 1..n-1, update `F` with the recurrence and track the maximum.

Time Complexity: O(n)
Space Complexity: O(1)

Solution: See `Solution.java` for the implementation.

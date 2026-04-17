# 3761 - Minimum Absolute Distance Between Mirror Pairs

**Problem Link:** LeetCode #3761: Minimum Absolute Distance Between Mirror Pairs

---

## Problem Statement
Given an integer array `nums`, find the minimum index distance `|i - j|` such that
`nums[i]` is the digit-reverse of `nums[j]`.
If no such mirror pair exists, return `-1`.

---

## Approach (Hash Map of Expected Mirrors)
1. Traverse the array from left to right.
2. Maintain a hash map `prev` where:
	- key = number we are currently waiting for
	- value = most recent index that would form a mirror pair if key appears
3. At index `i` with value `x`:
	- If `x` exists in `prev`, then we found a valid mirror pair with index `prev[x]`.
	- Update answer with `i - prev[x]`.
	- Insert `reverse(x)` into `prev` with current index `i`.
4. Return `-1` if answer was never updated.

---

## Why This Works
When processing `x` at position `i`, any earlier index `j` forms a mirror pair iff
`reverse(nums[j]) == x`.
By storing `reverse(nums[j])` in the map while scanning, a direct lookup at `x`
instantly tells whether such a `j` exists.
Because we check all indices in order and keep minimum distance, the final answer is correct.

---

## Time and Space Complexity
- Let `n = nums.length`.
- Each element is processed once with O(1) average map operations.
- Reversing digits takes O(d), where `d` is number of digits (small constant for int bounds).
- Total Time: `O(n)`
- Space: `O(n)`

---

## Java Solution
See [Solution.java](Solution.java).

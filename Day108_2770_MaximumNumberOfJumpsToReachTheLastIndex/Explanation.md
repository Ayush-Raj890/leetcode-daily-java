# 2770. Maximum Number of Jumps to Reach the Last Index

Approach summary:

- Use depth-first search with memoization from index `0`.
- From each position, try every later index that satisfies `abs(nums[i] - nums[j]) <= target`.
- Cache the maximum number of jumps from each index so each subproblem is solved once.
- Return `-1` when the last index is unreachable.

This matches the repository convention: `Solution.java` contains the implementation and `Explanation.md` contains the notes.

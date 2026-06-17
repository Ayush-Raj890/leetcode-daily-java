# Day 145 - 3614. Process String with Special Operations II

## Problem
Given a string `s`, interpret it using these operations:
- `*` removes the last character if one exists.
- `#` duplicates the current string.
- `%` reverses the current string.
- Lowercase letters are appended as-is.

Return the character at index `k` in the final string, or `'.'` if `k` is out of bounds.

## Approach
Track the length of the string after each step, but do not build the full string. Then walk backward through the operations and translate `k` into the matching position before each operation:
- `*` does not affect the stored index.
- `#` maps the second half back to the first half.
- `%` mirrors the index within the current prefix.
- A letter is returned when the backward-mapped position lands on it.

This avoids constructing an exponentially large string and keeps the solution efficient.

## Complexity
- Time: `O(n)`
- Space: `O(n)`

## Code Reference
See [Solution.java](Solution.java) for the implementation.
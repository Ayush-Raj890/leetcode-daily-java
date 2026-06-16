# Day 144 - 3612. Process String with Special Operations I

## Problem
Given a string `s`, process it character by character using these rules:
- `*` removes the last character if one exists.
- `#` duplicates the current string.
- `%` reverses the current string.
- Lowercase letters are appended as-is.

Return the final string after all operations are applied.

## Approach
Use a `StringBuilder` to maintain the current result while scanning the input once:
- Append lowercase letters directly.
- Delete the last character when seeing `*`, if the builder is non-empty.
- Duplicate the current content with `sb.append(sb)` for `#`.
- Reverse the builder in place for `%`.

This keeps the implementation compact and follows the operation order exactly as defined.

## Complexity
- Time: `O(n)` plus the cost of string builder operations.
- Space: `O(n)` for the growing result.

## Code Reference
See [Solution.java](Solution.java) for the implementation.
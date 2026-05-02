# 788. Rotated Digits

## Approach
- Use dynamic programming to classify each number from `0` to `n`.
- Mark digits `0, 1, 8` as valid but unchanged after rotation.
- Mark digits `2, 5, 6, 9` as valid and changing after rotation.
- Mark any number containing `3, 4, 7` as invalid.
- Count numbers that stay valid and change after rotation.

## Why this works
A number is good if every digit is rotatable and at least one digit changes to a different digit after rotation. The DP state lets us build this classification incrementally from smaller numbers.

## Complexity
- Time: `O(n)`
- Space: `O(n)`
# 2078. Two Furthest Houses With Different Color

## Approach
- Find the first index from the left whose color is different from the last house color.
- Find the first index from the right whose color is different from the first house color.
- The answer is the maximum of these two distances.

## Time Complexity
- `O(n)`

## Space Complexity
- `O(1)`

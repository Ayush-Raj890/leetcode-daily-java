# 1861. Rotating the Box

## Problem
You are given an `m x n` matrix `grid` where each cell is either:
- `'#'` - a stone
- `'*'` - a fixed obstacle
- `'.'` - empty

Stones fall down to the bottom due to gravity. After falling, rotate the resulting matrix 90 degrees clockwise.

## Approach
1. First, apply gravity to each row from left to right
   - Swap stones (`.`) towards the left (before hitting obstacles `*`)
2. Then rotate the grid 90 degrees clockwise
   - New cell at `res[c][rows-1-r]` = old cell at `grid[r][c]`

## Complexity
- Time: O(m*n) - one pass through grid for gravity, one pass for rotation
- Space: O(m*n) - for the rotated result matrix

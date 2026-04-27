# 1391. Check if There is a Valid Path in a Grid

## Approach
- Treat each street type as a set of allowed direction transitions.
- For the starting cell, only two directions can be chosen, based on the street shape.
- Walk deterministically through the grid once a starting direction is chosen.
- At each step, use a transition table to compute the only valid next direction.
- If we reach the bottom-right cell, the path is valid.
- If the walk leaves the grid, hits an invalid transition, or comes back to the start, the path is invalid.

## Complexity
- Time: O(m * n) in the worst case for the two start-direction checks.
- Space: O(1)

`m` = number of rows, `n` = number of columns.
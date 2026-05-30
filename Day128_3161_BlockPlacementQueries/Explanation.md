# Day 128 - 3161. Block Placement Queries

## Problem Statement
Maintain a line with placed blocks and answer queries about whether a block of a given size can fit within the free space available up to a position, while also supporting block placements that split existing gaps.

## Approach
Process the queries in reverse. This turns deletions into easy removals from the obstacle set and lets us prebuild the initial gaps between all placed obstacles.

Use two data structures:
1. A `TreeSet` to track obstacle positions and quickly find neighboring obstacles.
2. A segment tree to store the maximum gap length ending at each obstacle.

For each reverse query:
- If it is a type `2` query, find the nearest obstacle on the left of `x`, then check the best gap available before that obstacle and the partial space from that obstacle to `x`.
- If it is a type `1` query, remove the obstacle from the set and merge the two adjacent gaps by updating the segment tree.

## Why This Works
Reversing the timeline lets us avoid complicated online gap splitting. Each obstacle removal in reverse corresponds to a placement in the forward direction, and the segment tree always stores the best available gap information for the current reversed state.

## Time and Space Complexity
- Time: `O(q log q)`
- Space: `O(q)`

## Code Reference
See [Solution.java](Solution.java) for the implementation.
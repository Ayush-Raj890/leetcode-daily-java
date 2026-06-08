# Day 137 - 2161. Partition Array According to Given Pivot

## Problem
Reorder the array so that values smaller than the pivot come first, followed by values equal to the pivot, followed by values greater than the pivot.

## Approach
Use two pointers to place elements into the result array from both ends at the same time. Scan from the left to collect values smaller than the pivot in their original order, and scan from the right to place values greater than the pivot from the back so their relative order is preserved. After that, fill the remaining middle section with the pivot value.

## Complexity
- Time: `O(n)`
- Space: `O(n)`

## Code Reference
See [Solution.java](Solution.java) for the implementation.
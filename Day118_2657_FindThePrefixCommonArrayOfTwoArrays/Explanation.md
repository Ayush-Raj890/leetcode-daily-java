# 2657. Find the Prefix Common Array of Two Arrays

Approach summary:

- For each prefix ending at index `i`, compare every element in `A[0..i]` against every element in `B[0..i]`.
- Count a match when the values are equal, then store the total for that prefix.
- Repeat until all prefix counts are computed.

Time complexity: O(n^3), Space complexity: O(n).

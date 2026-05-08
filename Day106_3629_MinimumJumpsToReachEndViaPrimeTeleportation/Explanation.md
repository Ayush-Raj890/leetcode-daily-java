# 3629. Minimum Jumps to Reach End via Prime Teleportation

## Approach
- Precompute a sieve where `prime[x] == true` means `x` is not prime.
- Group indices by value using a linked-list style bucket array so every value can be traversed quickly.
- Run BFS from index `0`.
- From each index, try the adjacent moves `i - 1` and `i + 1`.
- If the current value is composite and has not been expanded before, teleport to every index whose value is a multiple of that number.
- Clear each visited bucket after processing so the same value groups are not scanned again.

## Complexity
- Time: O(n + M log log M)
- Space: O(n + M)

Where `M` is the maximum value in `nums`.

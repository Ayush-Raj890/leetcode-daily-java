# 61. Rotate List

Given the head of a singly linked list, rotate it to the right by `k` places.

## Idea

The key observation is that rotating a list to the right by `k` positions is the same as moving the last `k` nodes to the front while preserving their order.

Instead of shifting nodes one by one, we can do this in one pass after finding the list length:

1. Find the length of the list and the tail node.
2. Reduce `k` using `k % length`, because rotating by the full length brings the list back to its original state.
3. Connect the tail to the head to temporarily make the list circular.
4. Walk to the new tail, which is the node at position `length - k`.
5. Break the circle and return the new head.

## Why this works

If the list has length `n`, then rotating right by `k` means the new head is the `(n - k)`-th node in 1-based indexing.

By linking the tail back to the head, we create a cycle so the nodes are easy to rewire without losing access to any part of the list. After moving to the correct new tail, cutting the link there gives us the rotated list.

## Example

For `head = [1,2,3,4,5]` and `k = 2`:

- Length = `5`
- `k % 5 = 2`
- Make the list circular: `1 -> 2 -> 3 -> 4 -> 5 -> 1`
- New tail is at position `5 - 2 = 3`, which is node `3`
- New head is node `4`
- Break after node `3`

Result: `[4,5,1,2,3]`

## Edge Cases

- Empty list: return `null`
- Single-node list: rotation does nothing
- `k = 0`: return the original list
- `k` larger than the list length: use `k % length`

## Complexity

- Time: `O(n)`
- Space: `O(1)`

## Solution

See [Solution.java](Solution.java) for the implementation.

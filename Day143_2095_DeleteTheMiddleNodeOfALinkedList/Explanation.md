# Day 143 - 2095. Delete the Middle Node of a Linked List

## Problem
Given the head of a linked list, delete the middle node and return the head of the modified list.

## Approach
Handle the single-node case first by returning `null`. For longer lists, use two pointers to find the node before the middle:
- `slow` moves one step at a time.
- `fast` moves two steps at a time.

Initialize `fast` at `slow.next.next`, so when traversal finishes, `slow` is positioned right before the middle node. Then skip the middle node using `slow.next = slow.next.next`.

## Complexity
- Time: `O(n)`
- Space: `O(1)`

## Code Reference
See [Solution.java](Solution.java) for the implementation.

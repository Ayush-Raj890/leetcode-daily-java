# 🧹 Day 54 – Remove Nodes By Values

## 🧩 Problem Statement

Given an array `nums` and the head of a singly linked list, delete every node from the list whose value appears in `nums`. Return the modified list.

LeetCode: 3217. Delete Nodes From Linked List Present in Array

---

## 💡 Approach

- Store all values from `nums` in a `HashSet` for O(1) lookups.
- Skip leading nodes whose values are in the set (move head forward).
- Traverse with a pointer `curr` and bypass nodes (`curr.next = curr.next.next`) while the next node’s value is in the set.
- Return the possibly updated `head`.

This avoids extra allocations and preserves relative order of remaining nodes.

---

## ✅ Example

Input:
- nums = [1, 3, 4]
- list = 1 → 2 → 3 → 4 → 5

Process:
- Remove 1, 3, 4

Output:
- 2 → 5

---

## ⏱️ Complexity

- Time: O(n + k), where n = list length, k = nums length
- Space: O(k) for the set

---

## 📝 Notes

- Handle the case where the head itself must be removed (advance head).
- Works even if all nodes are removed (returns null).
- No dummy node needed; direct head adjustment plus in-place linking.
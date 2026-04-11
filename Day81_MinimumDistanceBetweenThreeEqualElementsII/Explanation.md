# Day 81 - Minimum Distance Between Three Equal Elements II

**Problem Link:** LeetCode #3741: Minimum Distance Between Three Equal Elements II

---

## Problem Statement
Given an integer array `nums`, find the minimum distance for any three equal elements.

If a value appears at indices `i < j < k`, compute the candidate as `k - i`.
Return `-1` if no such triple exists. Otherwise, return double the minimum value.

---

## Approach
We preprocess the next occurrence for each index:
- `next[i]` stores the next index where `nums[i]` appears.
- If none exists, it is `-1`.

Then for each index `i`:
- Let `secondPos = next[i]`
- Let `thirdPos = next[secondPos]`
- If both exist, we found three equal elements at `i`, `secondPos`, `thirdPos`
- Update answer with `thirdPos - i`

Finally:
- If no triple was found, return `-1`
- Else return `answer * 2`

---

## Why This Works
- `next` links each occurrence to the immediate next one of the same value.
- Chaining `next` twice from `i` gives the second and third occurrences in order.
- Checking all indices guarantees we consider all valid triples.
- Taking the minimum over all valid triples gives the required minimum distance.

---

## Time and Space Complexity
- **Time Complexity:** `O(n)`
- **Space Complexity:** `O(n)` for `next` and hash map

---

## Java Solution
See [Solution.java](Solution.java).

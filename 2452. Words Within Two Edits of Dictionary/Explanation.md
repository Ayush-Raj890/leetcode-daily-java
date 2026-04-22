# 2452. Words Within Two Edits of Dictionary

## Approach
- For each query word, compare it with every dictionary word.
- Count mismatched positions while scanning characters.
- If mismatches exceed 2, stop early for that dictionary word.
- If any dictionary word has at most 2 mismatches, include the query in the answer.

## Why this works
A query is valid if there exists at least one dictionary word differing by at most two positions. The helper check directly verifies this condition.

## Complexity
- Let `q` = number of queries
- Let `d` = number of dictionary words
- Let `m` = word length

Time: `O(q * d * m)`
Space: `O(1)` extra (excluding output list)

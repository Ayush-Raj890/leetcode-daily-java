# Day 126 - 3093. Longest Common Suffix Queries

## Approach

Build a trie over the reversed container words. Each trie node stores the index of the shortest word seen on that path, with ties broken by the smaller index.

For every query, walk the trie from the reversed query string as far as possible. The best index stored at the deepest reachable node is the answer, because that node represents the longest common suffix match.

## Complexity

- Build time: `O(total characters in wordsContainer)`
- Query time: `O(total characters in wordsQuery)`
- Space: `O(total characters in wordsContainer)`
# 3043. Find the Length of the Longest Common Prefix

Approach summary:

- Insert every number from `arr2` into a digit trie.
- For each number in `arr1`, walk the trie digit by digit until the path breaks.
- The number of matched digits is the common prefix length for that value.
- Keep the maximum match across all values in `arr1`.

Time complexity: O(total digits in `arr1` + total digits in `arr2`), Space complexity: O(total digits in `arr2`).
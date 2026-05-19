# 2540. Minimum Common Value

Approach summary:

- Use a `HashSet` to store all elements from `nums1`.
- Iterate through `nums2` and return the first element found in the set.
- If no common element exists, return `-1`.

Time complexity: O(n + m), Space complexity: O(n).

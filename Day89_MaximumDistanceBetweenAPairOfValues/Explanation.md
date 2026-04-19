# 1855. Maximum Distance Between a Pair of Values

## Approach
- Use two pointers, one for `nums1` and one for `nums2`.
- Move the second pointer forward while the condition `nums1[i] <= nums2[j]` holds.
- When the condition breaks, advance the first pointer and continue.
- The final distance is the largest valid index difference found by this sweep.

## Java Solution
```java
class Solution {
    public int maxDistance(int[] A, int[] B) {
        int i, j = 1;

        for (i = 0; i < A.length && j < B.length; j++) {
            if (A[i] > B[j]) {
                i++;
            }
        }

        return j - i - 1;
    }
}
```

## Complexity
- Time: O(n + m)
- Space: O(1)

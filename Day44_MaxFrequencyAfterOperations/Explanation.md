# LeetCode #: Max Frequency After Operations

## Problem
You are given an integer array `nums`, and two integers `k` and `numOperations`.  
You may perform up to `numOperations` operations. In one operation, you may increase or decrease an element by at most `k`.  
Return the maximum possible frequency (the maximum count of equal elements) achievable after at most `numOperations` operations.

## Approach / Idea
1. Sort `nums` to make range queries and counting simpler.
2. Use binary-search-style helpers (`lowerBound` and `upperBound`) to count how many elements lie within given numeric intervals quickly.
3. For each candidate target value `n` (and also check `n - k` and `n + k` to cover edge cases), compute:
   - how many elements already equal `n` (freq),
   - how many elements fall into the convertible range `[n - k, n + k]`,
   - how many of those can be converted given `numOperations`.
4. Combine the above to compute the achievable frequency for that target, and track the maximum over all candidates.

This uses counting via prefix-like index arithmetic using lower/upper bounds after sorting.

## Complexity
- Time Complexity: `O(n log n)` for sorting plus `O(n log n)` for the binary searches in the loop — overall `O(n log n)`.
- Space Complexity: `O(1)` extra space (aside from input and sorting overhead).

## Code
```java
import java.util.*;

class Solution {
    private int check(int[] nums, int n, int t, int m) {
        long nL = n;
        long tL = t;
        int l = lowerBound(nums, nL);
        int h = upperBound(nums, nL);
        int ll = lowerBound(nums, nL - tL);
        int hh = upperBound(nums, nL + tL);
        int res = (hh - h) + (l - ll);
        return Math.min(m, res) + (h - l);
    }

    private int lowerBound(int[] arr, long target) {
        int l = 0, r = arr.length;
        while (l < r) {
            int mid = (l + r) / 2;
            if (arr[mid] < target) l = mid + 1;
            else r = mid;
        }
        return l;
    }

    private int upperBound(int[] arr, long target) {
        int l = 0, r = arr.length;
        while (l < r) {
            int mid = (l + r) / 2;
            if (arr[mid] <= target) l = mid + 1;
            else r = mid;
        }
        return l;
    }

    public int maxFrequency(int[] nums, int k, int numOperations) {
        int m = numOperations;
        Arrays.sort(nums);
        int ans = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            ans = Math.max(ans, check(nums, nums[i], k, m));
            ans = Math.max(ans, check(nums, nums[i] - k, k, m));
            ans = Math.max(ans, check(nums, nums[i] + k, k, m));
        }
        return ans;
    }
}
Sorting + binary-search range counting lets us quickly compute how many elements lie in convertible intervals.

Checking n, n - k, and n + k for each candidate guards edge cases where shifting the target slightly yields better results.

The helper check computes contribution of elements inside and outside the target bucket and caps added conversions by numOperations.
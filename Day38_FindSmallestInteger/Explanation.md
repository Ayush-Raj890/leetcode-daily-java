# LeetCode #2348: Find Smallest Integer

## Problem
Given an integer array `nums` and an integer `value`, return the **smallest non-negative integer `x`** such that there is no element in `nums` that is congruent to `x` modulo `value`.

## Approach / Idea
1. Calculate the frequency of each remainder when elements of `nums` are taken modulo `value`.  
2. Initialize `res = 0`.  
3. While `res % value` has a frequency count > 0, increment `res` and decrement the count.  
4. Once the count of `res % value` is 0, `res` is the smallest integer not present modulo `value`.

This effectively distributes numbers across modulo buckets and finds the first missing integer.

## Complexity
- Time Complexity: O(n + value) → n for iterating array, value for remainder checks.  
- Space Complexity: O(value) → for the remainder frequency array.

## Code
```java
class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        int n = nums.length, res = 0;
        int[] rem = new int[value];
        for (int x : nums) {
            int r = ((x % value) + value) % value;
            rem[r]++;
        }
        while (rem[res % value]-- > 0) res++;
        return res;
    }
}
Examples / Output
Input: nums = [1, -10, 7, 13, 6, 8], value = 5
Output: 0

Input: nums = [3, 0, 3, 2, 4, 2, 1, 4], value = 7
Output: 5
Summary / Insights

Using modulo buckets is an efficient way to track missing values in modular arithmetic problems.

Negative numbers are handled carefully using (x % value + value) % value.
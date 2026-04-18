# 3783. Mirror Distance of an Integer

## Approach
- Reverse the digits of the given integer `n`.
- Compute the absolute difference between the reversed number and the original number.

## Java Solution
```java
class Solution {
    static public int mirrorDistance(int n) {
        int rev = 0;
        for (int x = n; x > 0; x /= 10) {
            rev = 10 * rev + x % 10;
        }
        return Math.abs(rev - n);
    }
}
```

## Complexity
- Time: O(d), where d is the number of digits in `n`
- Space: O(1)

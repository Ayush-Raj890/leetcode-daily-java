# 2833. Furthest Point From Origin

## Approach
- Count how many moves go left, right, and how many are blanks.
- The fixed moves leave a net displacement of `abs(left - right)`.
- Every blank can be assigned to whichever direction increases the distance, so each one adds `1`.
- The answer is therefore `abs(left - right) + blanks`.

## Java Solution
```java
class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int left = 0, right = 0, blanks = 0;

        for (char c : moves.toCharArray()) {
            if (c == 'L') left++;
            else if (c == 'R') right++;
            else blanks++;
        }

        return Math.abs(left - right) + blanks;
    }
}
```

## Complexity
- Time: O(n)
- Space: O(1)
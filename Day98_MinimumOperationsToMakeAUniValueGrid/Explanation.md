# 2033. Minimum Operations to Make a Uni-Value Grid

## Approach
- All grid values must be reachable from each other using steps of size `x`; otherwise the answer is `-1`.
- Flatten the values conceptually and bucket them by value so we can count frequencies.
- The minimum number of operations is achieved by moving every value toward the median reachable value.
- Scan the reachable values in sorted order to find that median, then sum the distance-to-median cost.

## Java Solution
```java
class Solution {
    public int minOperations(int[][] grid, int x) {
        int n = grid.length, m = grid[0].length;
        int N = n * m;
        int[] freq = new int[10001];
        int min = grid[0][0], max = min;

        for (int[] row : grid) {
            for (int val : row) {
                if ((val - grid[0][0]) % x != 0)
                    return -1;
                freq[val]++;
                min = Math.min(min, val);
                max = Math.max(max, val);
            }
        }

        int target = (N + 1) / 2;
        int acc = 0, median = min;

        for (int i = min; i <= max; i += x) {
            acc += freq[i];
            if (acc >= target) {
                median = i;
                break;
            }
        }

        int ops = 0;
        for (int i = min; i <= max; i += x)
            ops += Math.abs(i - median) / x * freq[i];

        return ops;
    }
}
```

## Complexity
- Time: `O(n * m + range / x)`
- Space: `O(1)` relative to the fixed frequency array
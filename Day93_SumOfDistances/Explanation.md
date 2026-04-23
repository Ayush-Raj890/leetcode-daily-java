# 2615. Sum of Distances

## Approach
- Group indices by value.
- For each group of indices, compute total sum of indices.
- Iterate the group from left to right:
- Distance contribution from left side = `idx * countLeft - leftSum`.
- Distance contribution from right side = `rightSum - idx * countRight`.
- Store total in answer for each original index.

## Java Solution
```java
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public long[] distance(int[] nums) {
        int n = nums.length;
        long[] ans = new long[n];

        Map<Integer, List<Integer>> mp = new HashMap<>();

        for (int i = 0; i < n; i++) {
            mp.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        for (List<Integer> pos : mp.values()) {
            long sum = 0;
            for (int x : pos) {
                sum += x;
            }

            long leftSum = 0;
            int m = pos.size();

            for (int i = 0; i < m; i++) {
                long rightSum = sum - leftSum - pos.get(i);

                long left = (long) pos.get(i) * i - leftSum;
                long right = rightSum - (long) pos.get(i) * (m - i - 1);

                ans[pos.get(i)] = left + right;

                leftSum += pos.get(i);
            }
        }

        return ans;
    }
}
```

## Complexity
- Time: O(n)
- Space: O(n)

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;
        Map<Integer, List<Integer>> map = new HashMap<>();

        // Store all indices for each value.
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        List<Integer> ans = new ArrayList<>();

        for (int q : queries) {
            List<Integer> positions = map.get(nums[q]);

            if (positions.size() == 1) {
                ans.add(-1);
                continue;
            }

            int pos = Collections.binarySearch(positions, q);
            int m = positions.size();

            int left = positions.get((pos - 1 + m) % m);
            int right = positions.get((pos + 1) % m);

            int leftDist = Math.abs(q - left);
            int rightDist = Math.abs(q - right);

            int best = Math.min(leftDist, n - leftDist);
            best = Math.min(best, Math.min(rightDist, n - rightDist));

            ans.add(best);
        }

        return ans;
    }
}

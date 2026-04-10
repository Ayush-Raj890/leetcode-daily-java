import java.util.HashMap;
import java.util.Map;

class Solution {

    public int minimumDistance(int[] nums) {
        Map<Integer, int[]> lastTwoPositions = new HashMap<>();
        int answer = Integer.MAX_VALUE;

        for (int index = 0; index < nums.length; index++) {
            int value = nums[index];
            int[] positions = lastTwoPositions.get(value);

            if (positions == null) {
                lastTwoPositions.put(value, new int[]{index, -1});
                continue;
            }

            if (positions[1] == -1) {
                positions[1] = index;
                continue;
            }

            answer = Math.min(answer, index - positions[0]);
            positions[0] = positions[1];
            positions[1] = index;
        }

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}

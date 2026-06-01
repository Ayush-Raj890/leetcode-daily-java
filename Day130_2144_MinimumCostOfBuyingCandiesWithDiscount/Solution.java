import java.util.Arrays;

class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);

        int total = 0;
        int take = 0;

        for (int i = cost.length - 1; i >= 0; i--) {
            take++;
            if (take % 3 != 0) {
                total += cost[i];
            }
        }

        return total;
    }
}
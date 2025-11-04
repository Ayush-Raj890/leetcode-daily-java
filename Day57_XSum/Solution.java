package Day57_XSum;

import java.util.*;

class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        
        Map<Integer, Integer> freq = new HashMap<>();
        Comparator<int[]> cmp = (a, b) -> {
            if (b[0] != a[0]) return b[0] - a[0];   
            return b[1] - a[1];                     
        };
        
        for (int i = 0; i < k; i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }
        
        for (int i = 0; i <= n - k; i++) {
            PriorityQueue<int[]> pq = new PriorityQueue<>(cmp);
            for (Map.Entry<Integer,Integer> e : freq.entrySet()) {
                pq.offer(new int[]{e.getValue(), e.getKey()});
            }
            long sum = 0;
            int count = 0;
            while (count < x && !pq.isEmpty()) {
                int[] top = pq.poll();
                sum += (long)top[0] * top[1];
                count++;
            }
            ans[i] = (int) sum;
            
            if (i < n - k) {
                int remove = nums[i];
                int add    = nums[i + k];
                
                freq.put(remove, freq.get(remove) - 1);
                if (freq.get(remove) == 0) {
                    freq.remove(remove);
                }
                
                freq.put(add, freq.getOrDefault(add, 0) + 1);
            }
        }
        
        return ans;
    }
}


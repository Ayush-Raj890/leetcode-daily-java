package Day30_AvoidFloodInTheCity;

import java.util.Arrays;

class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int m = potions.length;
        int[] result = new int[n];

        Arrays.sort(potions); 

        for (int i = 0; i < n; i++) {
            int spell = spells[i];
            // minimum potion required for success
            long required = (success + spell - 1) / spell;
            
            int index = binarySearch(potions, required);
            result[i] = m - index; 
        return result;
    }

    
    private int binarySearch(int[] potions, long required) {
        int low = 0, high = potions.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (potions[mid] < required) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}


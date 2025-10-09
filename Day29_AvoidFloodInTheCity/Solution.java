import java.util.*;

class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] res = new int[n];
        Map<Integer, Integer> fullLakes = new HashMap<>(); // lake -> last rain day
        TreeSet<Integer> dryDays = new TreeSet<>(); // indexes of dry days

        for (int i = 0; i < n; i++) {
            if (rains[i] == 0) {
                dryDays.add(i); // store index of dry day
                res[i] = 1; // default (in case we don't need it)
            } else {
                int lake = rains[i];
                res[i] = -1; // raining day
                
                if (fullLakes.containsKey(lake)) {
                    // find next available dry day after last rain of this lake
                    Integer dryDay = dryDays.higher(fullLakes.get(lake));
                    if (dryDay == null) {
                        // no dry day available -> flood
                        return new int[0];
                    }
                    res[dryDay] = lake; // dry this lake
                    dryDays.remove(dryDay); // remove used dry day
                }
                
                fullLakes.put(lake, i); // update last rain day for this lake
            }
        }

        return res;
    }
}

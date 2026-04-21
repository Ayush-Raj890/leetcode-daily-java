# 1722. Minimize Hamming Distance After Swap Operations

## Approach
- Treat each index as a node and each allowed swap as an edge.
- Build connected components using Disjoint Set Union (Union-Find).
- For each component, store frequencies of values from `source`.
- Traverse `target`: if `target[i]` exists in the frequency map of its component, consume one count.
- Otherwise, it contributes to the Hamming distance.

## Java Solution
```java
import java.util.HashMap;
import java.util.Map;

class Solution {
    private int[] parent;

    private int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    private void unite(int a, int b) {
        parent[find(a)] = find(b);
    }

    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;
        parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;

        for (int[] swap : allowedSwaps) {
            unite(swap[0], swap[1]);
        }

        Map<Integer, Map<Integer, Integer>> groups = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int root = find(i);
            groups.computeIfAbsent(root, k -> new HashMap<>())
                  .merge(source[i], 1, Integer::sum);
        }

        int hammingDist = 0;
        for (int i = 0; i < n; i++) {
            int root = find(i);
            Map<Integer, Integer> freq = groups.get(root);
            if (freq.getOrDefault(target[i], 0) > 0) {
                freq.merge(target[i], -1, Integer::sum);
            } else {
                hammingDist++;
            }
        }

        return hammingDist;
    }
}
```

## Complexity
- Time: O((n + m) * alpha(n)), where `m` is the number of allowed swaps
- Space: O(n)

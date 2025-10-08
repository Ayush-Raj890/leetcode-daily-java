# 📝 Day 30 – Avoid Flood In The City

## 📌 Problem Link
[LeetCode 1488 – Avoid Flood in The City](https://leetcode.com/problems/avoid-flood-in-the-city/)

## 💡 Problem Statement
You are given an array `rain` where:
- `rain[i] > 0` means it rains over lake `rain[i]`.
- `rain[i] == 0` means you can choose one lake to dry on that day.

Your goal is to avoid any lake flooding. A lake floods if it rains on it twice without being dried in between.  
You must return an array where:
- `res[i] = -1` if it rained that day.
- `res[i] = lakeNumber` if you choose to dry that lake on day `i`.
- If it's impossible to avoid flooding, return an empty array.

---

## 🧠 Example
**Input:**  
rain = [1,2,0,0,2,1]


**Output:**  
[-1,-1,2,1,-1,-1]


✅ On day 3, we dry lake 2.  
✅ On day 4, we dry lake 1.  
No lake floods.

---

## 🛠️ Approach

1. **Union-Find Structure** – used to find the next available dry day efficiently.  
2. **HashMap** – keeps track of the last rainy day for each lake.  
3. **Result Array** – initialized with `1` for drying days and `-1` for raining days.  
4. When it rains:
   - If the lake has already rained before and hasn’t been dried, find the next available dry day using Union-Find.
   - If no dry day is available, return an empty array.
   - Otherwise, dry that lake on the dry day.
5. Return the filled result array.

---

## ⏳ Complexity
- **Time Complexity:** `O(n α(n))` — where α is the Inverse Ackermann function (almost constant).  
- **Space Complexity:** `O(n)` — for maps and union-find arrays.

---

## 🏁 Final Code
```java
class Solution {
    public int[] avoidFlood(int[] rain) {
        int n = rain.length;
        UnionFind uf = new UnionFind(n + 1);
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[n];
        Arrays.fill(res, 1);

        for (int i = 0; i < n; i++) {
            int lake = rain[i];
            if (lake == 0) continue;

            res[i] = -1;
            uf.unite(i);

            if (map.containsKey(lake)) {
                int prev = map.get(lake);
                int dry = uf.find(prev + 1);

                if (dry >= i) return new int[0];

                res[dry] = lake;
                uf.unite(dry);
            }
            map.put(lake, i);
        }
        return res;
    }
}

class UnionFind {
    int[] parent;
    public UnionFind(int size) {
        parent = new int[size + 1];
        for (int i = 0; i <= size; i++) parent[i] = i;
    }

    public int find(int i) {
        if (parent[i] == i) return i;
        return parent[i] = find(parent[i]);
    }

    public void unite(int i) {
        parent[i] = find(i + 1);
    }
}
Significance

Demonstrates the use of Union-Find for scheduling and allocation problems.

Good example of greedy + disjoint set union for optimal resource management.

Helps understand time-slot allocation in simulation problems.
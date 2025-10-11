# 🧮 Day 33 – Maximum Total Damage

## 📌 Problem Statement
You are given an array `power` where each element represents the power of an attack. You can choose some of the attacks to maximize the total damage.  
However, if you choose a power `x`, you cannot choose powers `x-1`, `x-2`, or `x+1`, `x+2`.

Return the **maximum total damage** that can be achieved.

---

## 🧠 Approach

### 1. **Frequency Counting**
- Count how many times each power value appears.
- Store it in a frequency map so that you can calculate total damage contributed by each unique power value.

### 2. **Sort Unique Powers**
- Sort the unique power values to handle them in increasing order.

### 3. **Dynamic Programming**
- Use `dp[i]` to store the maximum total damage considering powers up to index `i`.
- At each step:
  - **Take current power**: damage = frequency × value + dp[previous valid index]
  - **Skip current power**: damage = dp[i-1]
- Previous valid index = last index with power ≤ currentPower - 3 (found via binary search).

### 4. **Binary Search**
- Used to find the previous index efficiently where we can add the current power without violating the gap condition.

### 5. **Final Answer**
- The value in `dp[n-1]` gives the maximum total damage.

---

## 🧮 Complexity
- **Time:** `O(N log N)` (sorting + binary search per element)  
- **Space:** `O(N)` for dp and storing unique powers

---

## 🧪 Example
Input: power = [3, 4, 2, 8, 8, 10]
Frequencies: {2:1, 3:1, 4:1, 8:2, 10:1}

Sorted keys: [2,3,4,8,10]

dp[0] = 21 = 2
dp[1] = max(2, 31) = 3
dp[2] = max(3, 41) = 4
dp[3] = max(4, 82 + dp[0]) = 20
dp[4] = max(20, 10*1 + dp[1]) = 20

Answer = 20

---

## 🧑‍💻 Code Implementation

```java
class Solution {
    public long maximumTotalDamage(int[] power) {
        Map<Integer, Long> freq = new HashMap<>();
        for (int p : power) freq.put(p, freq.getOrDefault(p, 0L) + 1);

        List<Integer> keys = new ArrayList<>(freq.keySet());
        Collections.sort(keys);

        int n = keys.size();
        long[] dp = new long[n];
        dp[0] = freq.get(keys.get(0)) * keys.get(0);

        for (int i = 1; i < n; i++) {
            long take = freq.get(keys.get(i)) * keys.get(i);
            int prev = binarySearch(keys, i - 1, keys.get(i) - 3);
            if (prev >= 0) take += dp[prev];
            dp[i] = Math.max(dp[i - 1], take);
        }

        return dp[n - 1];
    }

    private int binarySearch(List<Integer> keys, int end, int value) {
        int l = 0, r = end, ans = -1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (keys.get(mid) <= value) {
                ans = mid;
                l = mid + 1;
            } else r = mid - 1;
        }
        return ans;
    }
}

🏁 Key Takeaways

Using frequency + DP is powerful for problems with constraints on selecting adjacent values.

Binary search helps efficiently find valid previous indices.

Similar logic is used in problems like House Robber but with a different skip rule.
# Day 40 – Max Distinct Elements (LeetCode #2779)

## 🧩 Problem
You are given an integer array `nums` and an integer `k`.  
You can **add or subtract any value between `0` and `k`** (inclusive) to each element in the array.  

Return the **maximum number of distinct elements** that can be obtained after performing these operations optimally.

---

## 💡 Approach / Idea
The key observation is that by sorting the array, we can greedily assign the smallest possible distinct value to each element within its allowed range.

### Steps:
1. Sort the array to process elements in increasing order.
2. Maintain a variable `prev` representing the **last chosen distinct value**.
3. For each element `x`:
   - Its range of possible values is `[x - k, x + k]`.
   - Choose the smallest value ≥ `prev + 1` (to ensure uniqueness).
4. If such a value exists within `[x - k, x + k]`, increment the count and update `prev`.
5. The count at the end gives the **maximum number of distinct elements**.

---

## ⏱️ Complexity
- **Time Complexity:** `O(n log n)` — for sorting the array.  
- **Space Complexity:** `O(1)` — no extra space used besides variables.

---

## 🧾 Example / Output
**Input:**  
`nums = [3,4,6,6,3], k = 2`  

**Output:**  
`5`  

**Explanation:**  
By adjusting values within ±2 range:  
`[3,4,6,6,3] → [1,3,5,7,9]` gives 5 distinct numbers.

---

## 🧠 Code (Java)
```java
class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = 0, prev = (int)-1e9;

        for (int x : nums) {
            int l = Math.max(x - k, prev + 1);
            if (l <= x + k) {
                prev = l;
                ans++;
            }
        }
        return ans;
    }
}
🪄 Summary / Insights

Greedy approach ensures each number takes the minimum possible unique value within range.

Sorting is essential to avoid overlap in intervals.

Elegant and efficient solution in O(n log n) time.
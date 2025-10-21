# Day 43 – Max Frequency After Operations (LeetCode #2968)

## 🧩 Problem
You are given an integer array `nums` and two integers `k` and `numOps`.

You can **perform at most `numOps` operations**, where in each operation, you may increase or decrease an element by **at most `k`**.  
Your goal is to maximize the **frequency of any number** (i.e., make as many elements equal as possible).

Return the **maximum possible frequency** achievable after applying at most `numOps` operations.

---

## 💡 Approach / Idea
We can solve this by using a **prefix sum frequency approach** over possible integer values.

### Key Idea:
1. First, count how many times each number appears.
2. Build a prefix sum array (`count`) to get cumulative frequencies up to each value.
3. For every possible integer `i`, consider it as a **target value**:
   - All elements within `[i - k, i + k]` can potentially be converted to `i`.
   - Calculate how many numbers fall in this range.
   - Compute the achievable frequency = current frequency + min(`numOps`, others in range that can be turned into `i`).

We take the **maximum** over all possible target values.

---

## 🧮 Steps
1. Find the maximum value in `nums` to size the count array.
2. Create a frequency array and convert it into prefix sums.
3. For each potential target `i`, calculate:
   - Left and right bounds (`i - k`, `i + k`).
   - Total numbers within that range.
   - Update result as the maximum achievable frequency.
4. Return the result.

---

## ⏱️ Complexity
- **Time Complexity:** `O(max(nums))` — we iterate through all values up to the largest possible number.  
- **Space Complexity:** `O(max(nums))` — for the prefix sum array.

---

## 🧾 Example / Output
**Input:**  
`nums = [1, 3, 5, 7], k = 2, numOps = 2`

**Output:**  
`3`

**Explanation:**  
You can make `[3, 5, 5, 5]` or `[3, 3, 5, 7]` — maximum frequency achievable = 3.

---

## 🧠 Code (Java)
```java
class Solution {
    public int maxFrequency(int[] nums, int k, int numOps) {
        int maxVal = Arrays.stream(nums).max().getAsInt() + k + 2;
        int[] count = new int[maxVal];

        for (int v : nums)
            count[v]++;

        for (int i = 1; i < maxVal; i++)
            count[i] += count[i - 1];

        int res = 0;
        for (int i = 0; i < maxVal; i++) {
            int left = Math.max(0, i - k);
            int right = Math.min(maxVal - 1, i + k);
            int total = count[right] - (left > 0 ? count[left - 1] : 0);
            int freq = count[i] - (i > 0 ? count[i - 1] : 0);
            res = Math.max(res, freq + Math.min(numOps, total - freq));
        }

        return res;
    }
}

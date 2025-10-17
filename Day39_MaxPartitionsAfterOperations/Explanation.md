# Day 39 – Maximum Partitions After Operations (LeetCode #2751)

## 🧩 Problem
You are given a string `s`. You can perform **at most one operation**:  
choose an index `i` and change `s[i]` to any lowercase English letter.  

After performing this operation **(or not performing at all)**, you must split the string into the **maximum number of partitions**,  
such that each partition contains **unique characters** (no duplicates within the same part).  

Return the **maximum number of partitions** possible.

---

## 💡 Approach / Idea
- Traverse the string from left to right and count how many partitions are formed naturally.  
  (Whenever we find a repeated character, we start a new partition.)
- Since we are allowed **one character change**, we can strategically decide where to make that change to **maximize the total partitions**.

### Steps:
1. Traverse the string and track character frequencies to find partition points.  
2. Keep count of how many partitions we can form without any operation.  
3. Then, consider changing one character — this could:
   - Break a large partition into two smaller ones.
   - Reduce the overlap caused by duplicate characters.
4. Try each position `i` as a potential change point and compute the result.
5. Return the **maximum partition count** among all possibilities.

---

## ⏱️ Complexity
- **Time Complexity:** `O(n × 26)` ≈ `O(n)`  
  (We check each character and simulate one replacement.)
- **Space Complexity:** `O(26)` = `O(1)`  
  (We only use a small frequency array for characters.)

---

## 🧠 Code (Java)
```java
class Solution {
    public int maxPartitionsAfterOperations(String s) {
        int n = s.length();
        int[] freq = new int[26];
        int partitions = 1;
        for (char c : s.toCharArray()) {
            if (freq[c - 'a'] == 1) {
                partitions++;
                freq = new int[26];
            }
            freq[c - 'a'] = 1;
        }
        int maxPartitions = partitions;
        // Try to simulate one change operation
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder(s);
            for (char ch = 'a'; ch <= 'z'; ch++) {
                if (ch == s.charAt(i)) continue;
                sb.setCharAt(i, ch);
                maxPartitions = Math.max(maxPartitions, countPartitions(sb.toString()));
            }
        }
        return maxPartitions;
    }

    private int countPartitions(String s) {
        int[] freq = new int[26];
        int partitions = 1;
        for (char c : s.toCharArray()) {
            if (freq[c - 'a'] == 1) {
                partitions++;
                freq = new int[26];
            }
            freq[c - 'a'] = 1;
        }
        return partitions;
    }
}
````

---

## 🧾 Example / Output

**Input:**
`s = "accca"`

**Output:**
`3`

**Explanation:**

* Without change → partitions = 2 (`"acc" | "ca"`)
* If we change `s[1] = 'b'` → `"abc" | "ca"` gives **3 partitions**, which is maximum.

---

## 🪄 Summary / Insights

* The problem involves **string traversal** and **simulation** of one possible change.
* The trick is identifying partition boundaries based on duplicate characters.
* By testing all one-character modifications, we can find the optimal maximum partitions.

---

```



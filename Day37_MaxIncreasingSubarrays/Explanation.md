# 🧠 Problem Explanation – [Problem Title]

## 📌 Problem Statement
> (Write the problem statement in your own words or a short summary of what the problem asks.)

---

## 🧮 Example
**Input:**  
example input

**Output:**  

**Explanation:**  
Step-by-step explanation of how the output is derived from the input.

---

## 🧭 Approach
1. **Understand the problem:** Briefly explain what needs to be solved.  
2. **Think of different ways:** Mention brute force and then the optimal way.  
3. **Choose best approach:** Why you chose this method.  
4. **Step-by-step logic:** Bullet points or pseudocode.

---

## 🧠 Dry Run
| Step | Variables | Action | Result |
|------|-----------|--------|--------|
| 1    | ...       | ...    | ...    |
| 2    | ...       | ...    | ...    |

(Use table or list to show how the algorithm works on the example input.)

---

## 🧮 Complexity Analysis
- **Time Complexity:** O(…) — explain why.  
- **Space Complexity:** O(…) — explain why.

---

## 🧠 Key Takeaways
- What important concept this problem teaches.
- Any edge cases or tricky parts to remember.

---

## 🧾 Code (Java)
```java
// Your clean final solution code here
class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int n = nums.size();
        int up = 1, preUp = 0, res = 0;
        for (int i = 1; i < n; i++) {
            if (nums.get(i) > nums.get(i - 1)) {
                up++;
            } else {
                preUp = up;
                up = 1;
            }
            int half = up >> 1;
            int min = preUp < up ? preUp : up;
            int candidate = half > min ? half : min;
            if (candidate > res) res = candidate;
        }
        return res;
    }
}
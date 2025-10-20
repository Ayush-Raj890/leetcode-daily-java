# Day 42 – Final Value of Variable After Performing Operations (LeetCode #2011)

## 🧩 Problem
You are given an array of strings `operations` where each element is one of the following:
- `"++X"`  
- `"X++"`  
- `"--X"`  
- `"X--"`

Initially, the variable `X = 0`.  
After performing all the operations, return the **final value of X**.

---

## 💡 Approach / Idea
We simply track the variable `X` as we iterate through the array of operations.

### Key Idea:
- Each operation that **contains a '+'** increases `X` by 1.
- Each operation that **contains a '-'** decreases `X` by 1.

No complex logic or conditions are needed — we just scan the array once.

---

## 🧮 Steps:
1. Initialize `count = 0`.
2. For each string in `operations`:
   - If it contains `"+"`, increment `count`.
   - Else, decrement `count`.
3. Return the final value of `count`.

---

## ⏱️ Complexity
- **Time Complexity:** `O(n)` – iterate once over all operations.  
- **Space Complexity:** `O(1)` – uses a single integer counter.

---

## 🧾 Example / Output
**Input:**  
`operations = ["--X","X++","X++"]`

**Output:**  
`1`

**Explanation:**  
`X` starts at 0 → -1 → 0 → 1 → final value = **1**.

---

## 🧠 Code (Java)
```java
class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int count = 0;

        for (String op : operations) {
            if (op.contains("+")) {
                count++;
            } else {
                count--;
            }
        }
        return count;
    }
}

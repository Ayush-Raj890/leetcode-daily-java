# Day 32 – Maximum Energy Boost

## 🧠 Problem Statement

You are given two integer arrays `energyDrinkA` and `energyDrinkB` of the same length `n`.  
- On each of the `n` days, you can **either**:
  - Drink from A, or
  - Drink from B.

If you **switch from A to B** or **B to A**, you lose energy equal to the energy gained on that day.  

Your task is to **maximize the total energy** after `n` days.

---

## 🧮 Example

### Example 1:
Input: energyDrinkA = [1,3,1], energyDrinkB = [3,1,1]
Output: 5


✅ **Explanation:**  
- Day 1: Choose B → Energy = 3  
- Day 2: Choose A → Lose energy of A[2] = 3 (switch), net +0 (3-3)  
- Day 3: Choose A → Energy = 1  

Total = 3 + 0 + 1 = **4**

Better:
- Day 1: A (1), Day 2: A (3), Day 3: B (1, but lose 1 for switching)  
Total = 1 + 3 + 0 = **4**

Best:
- Day 1: B (3), Day 2: B (1), Day 3: B (1)  
Total = 3 + 1 + 1 = **5**

---

## 🧭 Constraints
- `1 <= n <= 10^5`
- `1 <= energyDrinkA[i], energyDrinkB[i] <= 10^5`

---

## 🧠 Approach (Dynamic Programming)

We can maintain two states:
- `dpA[i]` = maximum energy if we drink from **A on day i**
- `dpB[i]` = maximum energy if we drink from **B on day i**

### Transition:
- If we stay on the same drink:
  - `dpA[i] = dpA[i-1] + A[i]`
  - `dpB[i] = dpB[i-1] + B[i]`
- If we switch:
  - `dpA[i] = max(dpA[i], dpB[i-1] + A[i] - A[i])` → effectively `dpB[i-1]`
  - `dpB[i] = max(dpB[i], dpA[i-1] + B[i] - B[i])` → effectively `dpA[i-1]`

### Base case:
- `dpA[0] = energyDrinkA[0]`
- `dpB[0] = energyDrinkB[0]`

### Final answer:
`max(dpA[n-1], dpB[n-1])`

---

## 🧾 Dry Run

For `A = [1,3,1]`, `B = [3,1,1]`

| Day | dpA | dpB |
|-----|-----|-----|
| 0   |  1  |  3  |
| 1   | max(1+3, 3) = 4 | max(3+1, 1) = 4 |
| 2   | max(4+1, 4) = 5 | max(4+1, 4) = 5 |

✅ Answer = max(5,5) = **5**

---

## ⏳ Time & Space Complexity
- **Time Complexity:** `O(n)` — Single pass through the arrays.
- **Space Complexity:** `O(1)` — We only keep track of two variables (A and B).

---

## 💡 Significance
- This problem is a great example of **state transition in DP** where a penalty (switching cost) simplifies the state.
- It can also be solved with **greedy intuition**, but DP ensures correctness.

---

## 🧑‍💻 Code (Java)

```java
class Solution {
    public long maxEnergyBoost(int[] energyDrinkA, int[] energyDrinkB) {
        int n = energyDrinkA.length;
        long a = energyDrinkA[0];
        long b = energyDrinkB[0];

        for (int i = 1; i < n; i++) {
            long newA = Math.max(a + energyDrinkA[i], b);
            long newB = Math.max(b + energyDrinkB[i], a);
            a = newA;
            b = newB;
        }
        return Math.max(a, b);
    }
}
✅ Summary:

Use DP to handle switching cost efficiently.

Keep only two states (A and B) → O(1) space.

Maximize energy at the end of n days.
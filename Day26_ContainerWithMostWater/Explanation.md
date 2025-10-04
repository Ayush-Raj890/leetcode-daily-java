# 🧩 Day 26 – Container With Most Water

### 📘 Problem Statement
You are given an integer array `height` of length `n`.  
There are `n` vertical lines such that the two endpoints of the i<sup>th</sup> line are at `(i, 0)` and `(i, height[i])`.

Find two lines that together with the x-axis form a container, such that the container contains the most water.

Return the maximum amount of water a container can store.

---

### 🧠 Approach
We use the **two-pointer technique**:

1. Initialize two pointers:
   - `left` at the start (0)
   - `right` at the end (n - 1)
2. Calculate the current area:
area = min(height[left], height[right]) * (right - left)
3. Update the maximum area if this area is greater.
4. Move the pointer pointing to the **shorter line** inward since the area is limited by the smaller height.
5. Repeat until `left < right`.

This ensures we explore all potential containers efficiently.

---

### 🧩 Example
**Input:**  
`height = [1,8,6,2,5,4,8,3,7]`

**Process:**
- Start: left = 0, right = 8  
area = min(1,7) * 8 = 8  
- Move left → 1
- Compute new areas, update max when higher found.

**Output:**  
`49`

---

### ⏱️ Complexity Analysis
| Type | Complexity |
|------|-------------|
| Time | O(n) |
| Space | O(1) |

---

### 💡 Key Insight
- Using two pointers avoids checking all pairs (which would take O(n²)).
- The trick is that the smaller height limits the area, so we always move it inward to potentially find a larger height.

---

### ✅ Code
```java
class Solution {
 public int maxArea(int[] height) {
     int left = 0;
     int right = height.length - 1;
     int maxArea = 0;

     while (left < right) {
         int currentArea = Math.min(height[left], height[right]) * (right - left);
         maxArea = Math.max(maxArea, currentArea);

         if (height[left] < height[right]) {
             left++;
         } else {
             right--;
         }
     }

     return maxArea;
 }
}
🌟 Significance

This is one of the most classic two-pointer problems that demonstrates how to optimize brute-force approaches using a mathematical observation about the problem’s constraints.
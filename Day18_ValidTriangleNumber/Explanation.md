# Day 18 – Valid Triangle Number

## Problem Statement
You are given an integer array `nums`. Return the number of triplets chosen from the array that can make triangles if we take them as side lengths of a triangle.

A triplet `(nums[i], nums[j], nums[k])` forms a valid triangle if:
nums[i] + nums[j] > nums[k]

## Example
### Example 1
**Input:**  
nums = [2,2,3,4]  
**Output:**  
3  
**Explanation:**  
Valid combinations are:  
- (2,3,4)  
- (2,3,4) (other 2)  
- (2,2,3)  

### Example 2
**Input:**  
nums = [4,2,3,4]  
**Output:**  
4  

---

## Approach
1. Sort the array.  
2. Fix the largest side (`nums[i]`).  
3. Use two pointers (`left`, `right`) to find pairs that satisfy the triangle inequality.  
4. Count the number of valid pairs.  

---

## Dry Run
Input: `nums = [2,2,3,4]`  

- After sorting: [2,2,3,4]  
- i = 3 → largest side = 4  
  - left = 0, right = 2  
  - nums[0] + nums[2] = 2+3 = 5 > 4 ✅ → count += 2 (pairs: (2,3,4), (2,3,4))  
- i = 2 → largest side = 3  
  - left = 0, right = 1  
  - nums[0] + nums[1] = 2+2 = 4 > 3 ✅ → count += 1 (pair: (2,2,3))  

**Final Answer = 3**

---

## Complexity Analysis
- **Time Complexity:** `O(n^2)` (sorting + two pointer loop).  
- **Space Complexity:** `O(1)` (in-place).  

---

## Significance
This problem is a classic example of applying **sorting + two pointers** to count valid triplets efficiently instead of brute force `O(n^3)`.  

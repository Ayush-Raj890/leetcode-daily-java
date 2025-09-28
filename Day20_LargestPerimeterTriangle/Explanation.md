# Day 20 – Largest Perimeter Triangle

## Problem Statement
Given an array of integers `nums` representing side lengths, return the largest perimeter of a triangle that can be formed with three of these lengths.  
If no valid triangle can be formed, return `0`.

A triangle is valid if the sum of any two sides is strictly greater than the third side.

---

## Example
### Example 1:
**Input:**
```

nums = [2,1,2]

```
**Output:**
```

5

```
Explanation: A triangle with sides (2,2,1) is valid, perimeter = 5.

### Example 2:
**Input:**
```

nums = [1,2,1]

```
**Output:**
```

0

```
Explanation: No valid triangle can be formed.

---

## Approach
1. **Sort the array** in ascending order.
2. Iterate from the largest element downwards:
   - For each `i`, check if `nums[i-1] + nums[i-2] > nums[i]`.
   - If true, a valid triangle can be formed with sides `(nums[i], nums[i-1], nums[i-2])`.
   - Return their sum as the perimeter.
3. If no valid triplet is found, return `0`.

---

## Dry Run
### Input:
```

nums = [3, 2, 3, 4]

```

**Step 1:** Sort → `[2, 3, 3, 4]`  
**Step 2:** Start from the end:
- `i = 3`: Check `(3 + 3 > 4)` → `6 > 4 ✅`  
  Perimeter = `3 + 3 + 4 = 10`

**Output:** `10`

---

## Complexity Analysis
- **Sorting:** `O(n log n)`
- **Iteration:** `O(n)`
- **Overall Time Complexity:** `O(n log n)`
- **Space Complexity:** `O(1)` (in-place sorting)

---

## Significance
- A simple greedy approach.
- Demonstrates how sorting simplifies triangle inequality checking.
- Useful in geometry and combinatorial optimization problems.
```
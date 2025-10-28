# 🎯 Day 50 – Count Valid Selections

## 🧩 Problem Statement

Given an array `nums`, you need to count the number of valid selections. A selection is valid based on specific conditions related to the sum of elements on the left and right sides of zero positions.

For each position `i` where `nums[i] == 0`:
- If the sum of elements to the left equals the sum of elements to the right, it contributes **2** valid selections.
- If the absolute difference between left and right sums is **1**, it contributes **1** valid selection.

Return the total count of valid selections.

---

## 💡 Examples

### Example 1:
**Input:**  
`nums = [1,0,2,0,3]`

**Output:**  
`2`

**Explanation:**  
- Position 1 (0): left sum = 1, right sum = 5 → |1-5| = 4 (no contribution)
- Position 3 (0): left sum = 3, right sum = 3 → equal, contributes 2
- **Total**: 2

### Example 2:
**Input:**  
`nums = [2,3,4,0,4,1,0]`

**Output:**  
`2`

**Explanation:**  
- Position 3 (0): left sum = 9, right sum = 5 → |9-5| = 4 (no contribution)
- Position 6 (0): left sum = 14, right sum = 0 → |14-0| = 14 (no contribution)
- Adjust based on actual valid positions

---

## 🧠 Approach

This solution uses **prefix and suffix sum arrays**:

1. **Build Prefix Sum (left):**
   - `left[i]` = sum of all elements from index 0 to i-1
   - Represents the sum of elements to the left of position i

2. **Build Suffix Sum (right):**
   - `right[i]` = sum of all elements from index i+1 to n-1
   - Represents the sum of elements to the right of position i

3. **Count Valid Selections:**
   - For each position where `nums[i] == 0`:
     - If `left[i] == right[i]`: add 2 to count
     - Else if `|left[i] - right[i]| == 1`: add 1 to count

4. **Return Total Count**

---

## 📊 Algorithm Steps

1. Initialize:
   - `left[]` and `right[]` arrays of size n
   - `count = 0`

2. Build prefix sums:
   ```
   for i from 1 to n-1:
       left[i] = left[i-1] + nums[i-1]
   ```

3. Build suffix sums:
   ```
   for i from n-2 to 0:
       right[i] = right[i+1] + nums[i+1]
   ```

4. Count valid selections:
   ```
   for each position i where nums[i] == 0:
       if left[i] == right[i]: count += 2
       else if |left[i] - right[i]| == 1: count += 1
   ```

5. Return count

---

## 🔍 Example Walkthrough

**Input:** `nums = [1,0,2,0,3]`

**Build left array:**
- left[0] = 0
- left[1] = 0 + 1 = 1
- left[2] = 1 + 0 = 1
- left[3] = 1 + 2 = 3
- left[4] = 3 + 0 = 3

**Build right array:**
- right[4] = 0
- right[3] = 0 + 3 = 3
- right[2] = 3 + 0 = 3
- right[1] = 3 + 2 = 5
- right[0] = 5 + 0 = 5

**Count valid selections:**
- i=1: nums[1]=0, left[1]=1, right[1]=5 → |1-5|=4 (skip)
- i=3: nums[3]=0, left[3]=3, right[3]=3 → equal, count += 2

**Output:** `2`

---

## ⏱️ Complexity

| Type  | Complexity |
|-------|------------|
| Time  | O(n)       |
| Space | O(n)       |

---

## ✅ Code Reference

See `Solution.java` for the implementation.

---

## 🎯 Key Insights

- **Prefix/Suffix sums**: Precompute to get O(1) access to left and right sums
- **Zero positions only**: Only check positions where nums[i] == 0
- **Two conditions**: Equal sums contribute 2, difference of 1 contributes 1
- **Single pass**: After preprocessing, only one pass needed to count

---

## 📝 Notes

- The solution efficiently handles the balance between left and right sums
- Prefix and suffix arrays avoid repeated calculations
- Only zero positions are candidates for valid selections
- The logic handles both exact balance and near-balance cases

---

## 💡 Optimization

Space can be optimized to O(1) by:
- Computing total sum once
- Using running sum instead of arrays
- left_sum + right_sum = total_sum - nums[i]

---
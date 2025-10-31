# 🕵️ Day 53 – Get Sneaky Numbers

## 🧩 Problem Statement

You are given an array `nums` of length `n + 2` that contains numbers from `0` to `n-1`, where exactly **two numbers appear twice** (the "sneaky numbers") and the rest appear once.

Return an array containing the two sneaky numbers in any order.

**LeetCode Problem**: [3289. The Two Sneaky Numbers of Digitville](https://leetcode.com/problems/the-two-sneaky-numbers-of-digitville/)

---

## 💡 Examples

### Example 1:
**Input:**  
`nums = [0,1,1,0]`

**Output:**  
`[0,1]`

**Explanation:**  
Numbers 0 and 1 each appear twice.

### Example 2:
**Input:**  
`nums = [0,3,2,1,3,2]`

**Output:**  
`[2,3]`

**Explanation:**  
Numbers 2 and 3 each appear twice.

### Example 3:
**Input:**  
`nums = [7,1,5,4,3,4,6,0,9,5,8,2]`

**Output:**  
`[4,5]`

**Explanation:**  
Numbers 4 and 5 each appear twice.

---

## 🧠 Approach

This solution uses an **advanced XOR bit manipulation technique** to find two duplicates in O(n) time and O(1) space:

### Key Concepts:

1. **XOR Properties:**
   - `a ^ a = 0` (any number XOR with itself is 0)
   - `a ^ 0 = a` (any number XOR with 0 is itself)
   - XOR is commutative and associative

2. **Strategy:**
   - If we XOR all elements in `nums` with all numbers from `0` to `n-1`, all non-duplicate numbers cancel out
   - We're left with `a ^ b` where `a` and `b` are the two sneaky numbers

3. **Separation Technique:**
   - Find a bit position where `a` and `b` differ (rightmost set bit in `a ^ b`)
   - Use this bit to partition all numbers into two groups
   - XOR each group separately to extract `a` and `b`

---

## 📊 Algorithm Steps

### Step 1: Find XOR of Both Sneaky Numbers
```java
int xor = 0;
int n = nums.length - 2;

// XOR all elements in nums
for (int num : nums) xor ^= num;

// XOR with all expected numbers [0, n-1]
for (int i = 0; i < n; i++) xor ^= i;

// Now xor = a ^ b (where a and b are sneaky numbers)
```

### Step 2: Find Differentiating Bit
```java
int diffBit = xor & -xor;
// This isolates the rightmost set bit in xor
// This bit is 1 in either a or b, but not both
```

### Step 3: Partition and Find Both Numbers
```java
int a = 0, b = 0;

// Partition nums array
for (int num : nums) {
    if ((num & diffBit) == 0) a ^= num;
    else b ^= num;
}

// Partition expected numbers [0, n-1]
for (int i = 0; i < n; i++) {
    if ((i & diffBit) == 0) a ^= i;
    else b ^= i;
}
```

---

## 🔍 Example Walkthrough

**Input:** `nums = [0,3,2,1,3,2]`  
**Expected:** `[2,3]` (duplicates)

### Step 1: Calculate XOR
- `nums` = [0, 3, 2, 1, 3, 2]
- Expected = [0, 1, 2, 3]
- XOR all: `0^3^2^1^3^2 ^ 0^1^2^3 = 2^3 = 1` (binary: 01)

### Step 2: Find Differentiating Bit
- `xor = 1` (binary: 0001)
- `diffBit = 1 & -1 = 1` (binary: 0001)
- This is the rightmost bit where 2 and 3 differ

### Step 3: Partition
**Group 0 (bit 0 is 0):**
- From nums: 0, 2, 2
- From expected: 0, 2
- XOR: `0^2^2 ^ 0^2 = 2`

**Group 1 (bit 0 is 1):**
- From nums: 3, 1, 3
- From expected: 1, 3
- XOR: `3^1^3 ^ 1^3 = 3`

**Result:** `[2, 3]`

---

## ⏱️ Complexity

| Type  | Complexity |
|-------|------------|
| Time  | O(n)       |
| Space | O(1)       |

---

## ✅ Code Reference

See `Solution.java` for the implementation.

---

## 🎯 Key Insights

- **XOR cancellation**: Duplicate elements cancel each other out when XORed
- **Bit manipulation trick**: `x & -x` isolates the rightmost set bit
- **Partitioning strategy**: Using a differentiating bit to separate two unknowns
- **Space efficient**: No extra data structures needed

---

## 📝 Notes

### Why `xor & -xor` Works:
- `-xor` in two's complement flips all bits and adds 1
- `xor & -xor` keeps only the rightmost set bit
- Example: `xor = 6 (0110)`, `-xor = -6 (1010)`, `6 & -6 = 2 (0010)`

### Why This Approach:
- Hash set would use O(n) space
- Sorting would take O(n log n) time
- XOR approach achieves O(n) time and O(1) space

---

## 💡 Alternative Approaches

### Approach 1: Hash Set (Simpler but uses space)
```java
public int[] getSneakyNumbers(int[] nums) {
    Set<Integer> seen = new HashSet<>();
    List<Integer> result = new ArrayList<>();
    for (int num : nums) {
        if (!seen.add(num)) result.add(num);
    }
    return result.stream().mapToInt(i -> i).toArray();
}
```
- Time: O(n), Space: O(n)

### Approach 2: Mathematical Sum
```java
public int[] getSneakyNumbers(int[] nums) {
    int n = nums.length - 2;
    long actualSum = 0, expectedSum = 0;
    for (int num : nums) actualSum += num;
    for (int i = 0; i < n; i++) expectedSum += i;
    // Use sum and sum of squares to find both numbers
}
```
- More complex, requires careful overflow handling

---

## 🔢 Bit Manipulation Concepts Used

1. **XOR self-cancellation**: `a ^ a = 0`
2. **Rightmost set bit isolation**: `x & -x`
3. **Bit partitioning**: Group numbers by a specific bit
4. **Two's complement**: Understanding `-x` representation

---
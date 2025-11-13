# 🔢 Day 66 – Max Operations (String scan)

## 🧩 Problem summary / intent
Given a binary string s, the implementation scans left→right and computes a value by:
- Maintaining the count of '1' characters seen so far.
- Whenever a '0' occurs and the previous character is '1', adding the current number of seen '1's to the result.

(Interpretation: every time a "10" boundary appears, all previously seen '1's are counted toward the total.)

## 💡 Algorithm
- ones = 0, res = 0
- For each index i in s:
  - If s[i] == '1' → ones++
  - Else if s[i] == '0' and i>0 and s[i-1] == '1' → res += ones
- Return res

## ⏱ Complexity
- Time: O(n)
- Space: O(1)

## 🔢 Example
s = "11010"
- i=0 '1' → ones=1
- i=1 '1' → ones=2
- i=2 '0' and prev='1' → res += 2 (res=2)
- i=3 '1' → ones=3
- i=4 '0' and prev='1' → res += 3 (res=5)
Return 5

## ✅ Notes
- The code only adds when a '0' is immediately preceded by '1'; isolated zeros not following '1' don't change the result.
- Works in a single pass with constant extra memory.
# Day 75 - Decode the Slanted Ciphertext

**Problem Link:** [LeetCode #2075: Decode the Slanted Ciphertext](https://leetcode.com/problems/decode-the-slanted-ciphertext/)

---

## Problem Statement
You are given an encoded string and the number of rows used to write it in a matrix. The original text was written diagonally (top-left to bottom-right) in that matrix, and then the matrix was read row by row to form `encodedText`.

Your task is to reconstruct and return the original text after removing trailing spaces.

---

## Approach
This solution simulates the decoding process directly:

1. **Handle single row case:**
   If `rows == 1`, the text is already in correct order, so return `encodedText`.

2. **Compute matrix dimensions:**
   - `n = encodedText.length()`
   - `cols = n / rows`

3. **Traverse diagonals:**
   Start from each column in the first row (`c = 0` to `cols - 1`) and move diagonally:
   - next row: `r + 1`
   - next column: `j + 1`

   The matrix index for `(r, j)` in row-major order is:
   `r * cols + j`

4. **Trim trailing spaces:**
   The decoded message may end with extra spaces, so scan backward and remove them.

---

## Why This Works
- Each original diagonal starts at row `0` and some column `c`.
- Walking diagonally recreates characters in original writing order.
- Reading all such diagonals left to right reconstructs the complete plaintext.
- Only trailing spaces are removed, matching problem requirements.

---

## Time and Space Complexity
- **Time Complexity:** `O(n)`
  - Every character is visited at most once, plus one backward trim pass.
- **Space Complexity:** `O(n)`
  - `StringBuilder` stores the reconstructed text.

---

## Java Solution
```java
class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        if (rows == 1)
            return encodedText;

        int n = encodedText.length();
        int cols = n / rows;

        StringBuilder res = new StringBuilder(n);

        for (int c = 0; c < cols; c++) {
            int r = 0, j = c;
            while (r < rows && j < cols) {
                res.append(encodedText.charAt(r * cols + j));
                r++;
                j++;
            }
        }

        int end = res.length() - 1;
        while (end >= 0 && res.charAt(end) == ' ') {
            end--;
        }

        return res.substring(0, end + 1);
    }
}
```

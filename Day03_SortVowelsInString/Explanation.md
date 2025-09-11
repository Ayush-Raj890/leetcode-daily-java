# Day 03 – Sort Vowels in a String  

**Problem Link:** [LeetCode #2785: Sort Vowels in a String](https://leetcode.com/problems/sort-vowels-in-a-string/)  

---

## Problem Statement  
Given a string `s`, return a new string where only the vowels are sorted in ascending order, while all consonants and other characters remain in their original positions.  

**Vowels considered:**  
A, E, I, O, U, a, e, i, o, u

**Example 1:**  
Input: s = "lEetcOde"
Output: "lEOtcede"

**Example 2:**  
Input: s = "leetcode"
Output: "leotcede"

---

## Approach  

### Step 1: Extract vowels  
- Loop through the string and collect all vowels into a list.  
- Check for vowels using: `"AEIOUaeiou".indexOf(c) != -1`  

### Step 2: Sort the vowels  
- Sort the vowels alphabetically using `Collections.sort()`.  
- This ensures vowels are placed in correct ascending order when rebuilding the string.  

### Step 3: Rebuild the string  
- Use a `StringBuilder` to efficiently construct the final string.  
- Traverse the original string again:  
  - If the character is a vowel → replace it with the next sorted vowel from the list.  
  - Otherwise → keep the character as is.  

**Why this approach?**  
- Two-pass approach (collect → rebuild) keeps logic clean and simple.  
- Sorting ensures correct order for vowels.  
- `StringBuilder` is efficient since strings in Java are immutable.  

---

## Dry Run  

**Input:** `"lEetcOde"`  

1. Extract vowels → `[E, e, O, e]`  
2. Sort vowels → `[E, O, e, e]`  
3. Rebuild string:  
   - l → keep  
   - E → replace with `E`  
   - e → replace with `O`  
   - t → keep  
   - c → keep  
   - O → replace with `e`  
   - d → keep  
   - e → replace with `e`  

**Output:** `"lEOtcede"` ✅  

---

## Time & Space Complexity  

- **Time Complexity:**  
  - O(n) → traverse string twice  
  - O(k log k) → sort k vowels (k ≤ n)  
  - Overall → **O(n log n)** in worst case  

- **Space Complexity:**  
  - O(k) → store vowels  
  - O(n) → rebuild final string  
  - Overall → **O(n)**  

---

## Significance  
- Demonstrates **two-pass algorithm** (collect → process → rebuild).  
- Reinforces **efficient string manipulation** with `StringBuilder`.  
- Shows practical use of **`Collections.sort()`** for character lists.  
- Strengthens understanding of **selective sorting** and character classification.  

---



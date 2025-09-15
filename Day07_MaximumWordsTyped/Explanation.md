# Day 07 – Maximum Number of Words You Can Type

**Problem Link:** [LeetCode #1935: Maximum Number of Words You Can Type](https://leetcode.com/problems/maximum-number-of-words-you-can-type/)

---

## Problem Statement
You are given a string `text` consisting of words separated by single spaces and a string `broken` consisting of distinct characters.  
A word is **untypable** if it contains **at least one character** from `broken`.  

Return the number of words in `text` that can be typed fully without using any broken letters.

---

## Approach
1. Store all characters from `broken` into a **HashSet** for **O(1) lookup**.  
2. Split the `text` into words using space `" "`.  
3. For each word:  
   - Iterate through its characters.  
   - If any character is in the broken set → mark the word as untypable and skip it.  
4. Count only the words that do **not** contain any broken letters.  

---

## Dry Run
**Input:**  
`text = "hello world leetcode"`  
`broken = "ad"`  

- Broken letters = { 'a', 'd' }  
- Words = ["hello", "world", "leetcode"]  

1. "hello" → no 'a' or 'd' → ✅ count it  
2. "world" → contains 'd' → ❌ skip  
3. "leetcode" → contains 'd' → ❌ skip  

**Output:** `1`  

---

## Time & Space Complexity
- **Time Complexity:** O(N * L)  
  - N = number of words  
  - L = average word length  
- **Space Complexity:** O(B)  
  - B = number of broken letters  

---

## Significance
- Reinforces the use of **HashSet** for fast membership checking.  
- Strengthens problem-solving skills with **string processing**.  
- Useful in real-world scenarios like **keyboard error detection** and **text filtering**.

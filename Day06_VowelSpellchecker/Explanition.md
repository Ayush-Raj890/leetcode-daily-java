# Day 06 – Vowel Spellchecker  

**Problem Link:** [LeetCode #966: Vowel Spellchecker](https://leetcode.com/problems/vowel-spellchecker/)  

---

## Problem Statement  
Given a wordlist, we want to implement a spellchecker that corrects queries in the following priority order:  

1. **Exact match**: If the query matches exactly a word in the wordlist → return the same word.  
2. **Case-insensitive match**: If the query matches a word in the wordlist ignoring case → return the first such match.  
3. **Vowel-error match**: If the query matches a word in the wordlist when all vowels (`a, e, i, o, u`) are treated as interchangeable → return the first such match.  
4. If none of the above → return an empty string `""`.  

---

## Examples  

**Example 1:**  
Input:
wordlist = ["KiTe","kite","hare","Hare"]
queries = ["kite","Kite","KiTe","Hare","HARE","Hear","hear","keti","keet","keto"]

Output:
["kite","KiTe","KiTe","Hare","hare","","","KiTe","","KiTe"]


---

## Approach  

We handle the problem with **three levels of matching**:  

### Step 1: Preprocess the wordlist  
- Use a `Set` to store all words for **exact match**.  
- Use a `Map<String, String>` (`caseMap`) to store lowercase → original for **case-insensitive match**.  
- Use a `Map<String, String>` (`vowelMap`) to store devoweled form (replace vowels with `*`) → original for **vowel-error match**.  
- We use `putIfAbsent` to always keep the **first occurrence** in wordlist, as required by the problem.  

### Step 2: Answer queries  
For each query:  
1. If it exists in `exact` → return query.  
2. Else, check lowercase form in `caseMap`.  
3. Else, check devoweled form in `vowelMap`.  
4. If none match → return `""`.  

### Why this works?  
- Each rule is applied in strict priority order.  
- Maps give **O(1)** lookups.  
- Preprocessing ensures we don’t repeatedly convert words.  

---

## Dry Run  

**Input:**  
wordlist = ["KiTe","kite","hare","Hare"]
queries = ["kite","Kite","HARE","keti"]

- Preprocessing:  
  - exact = {"KiTe","kite","hare","Hare"}  
  - caseMap = {"kite":"KiTe","hare":"hare"}  
  - vowelMap = {"k*te":"KiTe","h*re":"hare"}  

- Query 1: `"kite"` → exact match → `"kite"`  
- Query 2: `"Kite"` → not exact → lowercase `"kite"` → caseMap → `"KiTe"`  
- Query 3: `"HARE"` → not exact → lowercase `"hare"` → caseMap → `"hare"`  
- Query 4: `"keti"` → not exact → lowercase `"keti"` → devowel `"k*ti"` → no match → `""`  

**Output:**  
["kite", "KiTe", "hare", ""]


---

## Time & Space Complexity  

- **Time Complexity:**  
  - Preprocessing wordlist: O(N * L)  
  - Answering Q queries: O(Q * L)  
  - Overall: **O((N + Q) * L)**  
  where N = size of wordlist, Q = number of queries, L = average word length.  

- **Space Complexity:**  
  - O(N * L) for storing sets and maps.  

---

## Significance  
- Teaches how to handle **multiple levels of matching** with different priorities.  
- Reinforces use of **HashSet** and **HashMap** for fast lookups.  
- Practical application of **string normalization** (case folding and vowel replacement).  
- Demonstrates careful use of `putIfAbsent` to preserve **first occurrence order**.  

---

✅ This completes **Day 06 – Vowel Spellchecker** 🚀

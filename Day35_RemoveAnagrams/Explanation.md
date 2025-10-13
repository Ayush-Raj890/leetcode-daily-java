# Day 35 – Remove Anagrams

## 📝 Problem Statement
You are given a string array `words`. You need to remove all strings that are **anagrams of the previous string** in the list, keeping only the first occurrence in each group.

Two words are considered **anagrams** if they contain the same characters with the same frequencies.

### Example
**Input:**  
words = ["abba","baba","bbaa","cd","cd"]
**Output:**  
["abba","cd"]
**Explanation:**  
- "abba", "baba", and "bbaa" are anagrams of each other.  
  So, we only keep the first occurrence: `"abba"`.  
- "cd" and "cd" are also anagrams, so we only keep the first `"cd"`.

---

## 🧠 Approach
1. For each word, count the frequency of each character.
2. Store these frequencies as a map for easy comparison.
3. Start from the first word and add it to the result.
4. For each subsequent word, compare its frequency map with the previous word:
   - If it's different, add it to the result.
   - If it's the same, skip it (because it's an anagram of the previous).
5. Return the final list of non-anagram words.

---

## ⏳ Complexity
- **Time Complexity:** `O(n * k)`  
  Where `n` is the number of words and `k` is the average word length.  
  (We count character frequencies and compare maps.)
  
- **Space Complexity:** `O(n * k)`  
  For storing frequency maps of each word.

---

## 🧪 Example Dry Run
words = ["abba","baba","bbaa","cd","cd"]

freq[0] = {a:2, b:2} -> added "abba"
freq[1] = {a:2, b:2} -> same as prev -> skip
freq[2] = {a:2, b:2} -> same as prev -> skip
freq[3] = {c:1, d:1} -> different -> added "cd"
freq[4] = {c:1, d:1} -> same as prev -> skip

Result = ["abba", "cd"]

---

## 🏁 Final Code
```java
class Solution {
    public List<String> removeAnagrams(String[] words) {
        int n = words.length;
        List<Map<Character, Integer>> freq = new ArrayList<>();
        for (String w : words) {
            Map<Character, Integer> map = new HashMap<>();
            for (char c : w.toCharArray())
                map.put(c, map.getOrDefault(c, 0) + 1);
            freq.add(map);
        }

        List<String> ans = new ArrayList<>();
        ans.add(words[0]);
        for (int i = 1; i < n; i++) {
            if (!freq.get(i).equals(freq.get(i - 1)))
                ans.add(words[i]);
        }
        return ans;
    }
}

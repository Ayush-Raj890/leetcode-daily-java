# Day 05: Find Most Frequent Vowel and Consonant — Explanation

## Problem Overview

Given a string `s`, the task is to find the **most frequent vowel** and the **most frequent consonant** in the string, then return the **sum of their frequencies**.

## Approach Explanation

We use a **single-pass frequency counting** approach for efficiency:

1. **Frequency Array**:  
   - We create an integer array `freq` of size 26 to count occurrences of each lowercase letter (`'a'` to `'z'`).
2. **Traverse the String**:  
   - For each character, increment its count in the `freq` array.
   - Check if the character is a vowel (`a`, `e`, `i`, `o`, `u`).
     - If yes, update `maxVowel` if its frequency is higher than the current maximum.
     - If not, update `maxConso` for consonants.
3. **Result**:  
   - After traversing the string, return the sum of `maxVowel` and `maxConso`.

## Why This Approach?

- **Time Efficient**: Only one pass through the string (`O(n)` time).
- **Space Efficient**: Only a fixed-size array (`O(1)` space).
- **Direct Calculation**: No need to sort or use extra data structures.

## Example

For input `"banana"`:
- Frequencies:  
  - Vowels: `a` appears 3 times.
  - Consonants: `n` appears 2 times, `b` appears 1 time.
- Most frequent vowel: `a` (3)
- Most frequent consonant: `n` (2)
- Output: `3 + 2 = 5`

## Summary

- Count frequencies for each character.
- Track the highest frequency for vowels and consonants.
- Return their sum for the answer.

This approach is simple, fast, and uses minimal memory.
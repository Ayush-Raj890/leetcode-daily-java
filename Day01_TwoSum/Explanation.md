# Day 01 – Two Sum

**Problem Link:** [LeetCode #1: Two Sum](https://leetcode.com/problems/two-sum/)

---

## Problem Statement
Given an array of integers `nums` and an integer `target`, return indices of the two numbers such that they add up to `target`.

---

## Approach
- Use a HashMap to store visited numbers and their indices.  
- For each number, check if `target - num` exists in the HashMap.  
- If yes, return the pair of indices.  

---

## Time & Space Complexity
- **Time Complexity:** O(n)  
- **Space Complexity:** O(n)  

---

## Significance
- Demonstrates how **HashMaps** provide efficient lookups.  
- First step toward learning optimized search techniques instead of brute force.  

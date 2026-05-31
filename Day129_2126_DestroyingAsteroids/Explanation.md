# Day 129 - 2126. Destroying Asteroids

## Problem
Given an integer `mass` and an array `asteroids`, determine whether you can destroy all asteroids by always choosing an asteroid whose size is less than or equal to your current mass. After destroying one asteroid, your mass increases by that asteroid's size.

## Approach
Sort the asteroids in ascending order and process them from smallest to largest. If the current asteroid is larger than your current mass, the process stops and the answer is `false`. Otherwise, absorb it and increase the mass.

## Complexity
- Time: `O(n log n)`
- Space: `O(1)`

## Code Reference
See [Solution.java](Solution.java) for the implementation.

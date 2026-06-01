# Day 130 - 2144. Minimum Cost of Buying Candies With Discount

## Problem
Given an array `cost`, buy all candies with the minimum total cost when every third candy is free, as long as the free candy is not more expensive than the two candies being paid for.

## Approach
Sort the costs in ascending order. Then iterate from the most expensive candy to the least expensive one. Since the best strategy is to pay for the two most expensive candies in each group of three and take the third one for free, we simply skip every third candy while adding the rest to the total.

## Complexity
- Time: `O(n log n)`
- Space: `O(1)`

## Code Reference
See [Solution.java](Solution.java) for the implementation.
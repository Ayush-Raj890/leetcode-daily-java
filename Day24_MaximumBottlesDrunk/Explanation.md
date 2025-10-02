# Day 24: Maximum Bottles Drunk — Explanation

## Problem Overview

Given an initial number of full bottles (`numBottles`) and an exchange rate (`numExchange`), you can drink a bottle and collect its empty bottle. Whenever you have enough empty bottles (at least `numExchange`), you can exchange them for one full bottle. The goal is to find the **maximum number of bottles you can drink**.

## Approach

We use a **simulation approach** to track the number of bottles drunk and the number of empty bottles available for exchange:

1. **Initialization**:
   - Start with `count = numBottles` (all bottles can be drunk initially).
   - Set `empty = numBottles` (all bottles become empty after drinking).

2. **Exchange Process**:
   - While the number of empty bottles is at least `numExchange`:
     - Exchange `numExchange` empty bottles for 1 full bottle.
     - Drink the new bottle, increment `count`.
     - Update the number of empty bottles: subtract the exchanged bottles, add the new empty bottle.
     - Increase `numExchange` if the exchange rate changes (as per problem statement).

3. **Termination**:
   - The process stops when you can no longer exchange empty bottles for a new full bottle.

4. **Result**:
   - Return the total number of bottles drunk (`count`).

## Example

Suppose `numBottles = 9`, `numExchange = 3`:
- Drink 9 bottles, collect 9 empty bottles.
- Exchange 3 empty bottles for 1 full bottle (now 7 empty bottles, 1 new bottle).
- Drink the new bottle (total 10), now 8 empty bottles.
- Repeat the process until you can't exchange anymore.

## Why This Approach?

- **Efficient**: Simulates the process in O(n) time.
- **Accurate**: Tracks both bottles drunk and empty bottles for exchange.
- **Simple**: No complex data structures needed.

## Summary

- Drink all initial bottles.
- Exchange empty bottles for new ones as long as possible.
- Track and return the total bottles drunk.

This approach ensures you maximize the number of bottles you can drink using the exchange process.
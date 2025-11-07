# ⚡ Day 60 – Maximum Power of Stations

## 🧩 Problem Summary
Given an array `stations` (power at each city), a radius `r` and `k` extra power units you can distribute across cities, compute the maximum possible minimum "power" any city can have after distributing at most `k` units. A city's current power equals the sum of station values within distance `r` (inclusive) from it.

## 💡 Key Ideas
- Precompute the initial power for every city using a sliding-window sum of width `2r+1`.
- Binary search the answer `T` = maximal achievable minimum power.
- For a candidate `T`, greedily simulate adding needed power: iterate cities left→right, track additional power applied via a difference array (range-add via start/end markers). When a city's total (initial + active additions) is below `T`, add the deficit at that city and schedule its removal after the window length — accumulate used units and abort if it exceeds `k`.
- If simulation succeeds within `k`, `T` is feasible; update binary search accordingly.

## 🧭 Algorithm Steps
1. Compute `power[i]` for each city i by sliding-window sum of `stations` over radius `r`.
2. Binary search `low..high` where `high = max(power) + k`.
3. For each mid `T` test feasibility:
   - Use a difference array `diff[]` and running `curAdd` to track active extra units affecting current index.
   - When `power[i] + curAdd < T`, add the deficit to `curAdd`, increment `used`, and schedule a subtraction at `i + windowSize`.
4. Return the largest feasible `T`.

## ⏱ Complexity
- Precompute powers: O(n).
- Each feasibility check: O(n) (difference array updates).
- Binary search iterations: O(log(maxPower + k)).
- Overall: O(n log(maxPower + k)) time, O(n) extra space.

## ✅ Notes / Tips
- Use long for sums and counters (`k`, power values) to avoid overflow.
- Difference-array trick enables range additions in O(1) amortized per operation — essential for O(n) feasibility checks.
- Setting `high = max(initial power) + k` is a safe upper bound for binary search.

## 🔢 Example (conceptual)
stations = [1,2,3,4,5], r = 1, k = 3  
- Compute initial window powers, binary-search target, simulate with diff array to check feasibility, and return the maximum achievable minimum power.
```// filepath: c:\Users\ayush\leetcode-daily-java\Day60_MaximumPowerOfStations\Explanation.md
# ⚡ Day 60 – Maximum Power of Stations

## 🧩 Problem Summary
Given an array `stations` (power at each city), a radius `r` and `k` extra power units you can distribute across cities, compute the maximum possible minimum "power" any city can have after distributing at most `k` units. A city's current power equals the sum of station values within distance `r` (inclusive) from it.

## 💡 Key Ideas
- Precompute the initial power for every city using a sliding-window sum of width `2r+1`.
- Binary search the answer `T` = maximal achievable minimum power.
- For a candidate `T`, greedily simulate adding needed power: iterate cities left→right, track additional power applied via a difference array (range-add via start/end markers). When a city's total (initial + active additions) is below `T`, add the deficit at that city and schedule its removal after the window length — accumulate used units and abort if it exceeds `k`.
- If simulation succeeds within `k`, `T` is feasible; update binary search accordingly.

## 🧭 Algorithm Steps
1. Compute `power[i]` for each city i by sliding-window sum of `stations` over radius `r`.
2. Binary search `low..high` where `high = max(power) + k`.
3. For each mid `T` test feasibility:
   - Use a difference array `diff[]` and running `curAdd` to track active extra units affecting current index.
   - When `power[i] + curAdd < T`, add the deficit to `curAdd`, increment `used`, and schedule a subtraction at `i + windowSize`.
4. Return the largest feasible `T`.

## ⏱ Complexity
- Precompute powers: O(n).
- Each feasibility check: O(n) (difference array updates).
- Binary search iterations: O(log(maxPower + k)).
- Overall: O(n log(maxPower + k)) time, O(n) extra space.

## ✅ Notes / Tips
- Use long for sums and counters (`k`, power values) to avoid overflow.
- Difference-array trick enables range additions in O(1) amortized per operation — essential for O(n) feasibility checks.
- Setting `high = max(initial power) + k` is a safe upper bound for binary search.

## 🔢 Example (conceptual)
stations = [1,2,3,4,5], r = 1, k = 3  
- Compute initial window powers, binary-search target, simulate with diff array to check feasibility, and return the maximum achievable minimum power.
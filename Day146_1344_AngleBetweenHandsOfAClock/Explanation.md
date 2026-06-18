# Day 146 - 1344. Angle Between Hands of a Clock

## Problem
Given the hour and minute on an analog clock, return the smaller angle between the hour hand and the minute hand.

## Approach
Convert the hour hand position into a decimal hour by adding the fraction contributed by the minutes. The difference between the two hands can then be expressed with a single formula that measures their separation on the clock face. Since a clock is circular, take the smaller of the direct angle and its complement.

## Complexity
- Time: `O(1)`
- Space: `O(1)`

## Code Reference
See [Solution.java](Solution.java) for the implementation.

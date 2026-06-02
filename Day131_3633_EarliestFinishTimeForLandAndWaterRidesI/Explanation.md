# 3633. Earliest Finish Time for Land and Water Rides I

This solution computes the earliest possible completion time if we take one land ride and one water ride in either order.

## Idea

1. Find the earliest finish time among all land rides.
2. Find the earliest finish time among all water rides.
3. Try land first, then water: the second ride can start no earlier than the land finish time or its own start time.
4. Try water first, then land with the same logic.

## Why it works

For each ordering, the best first ride is simply the one with the smallest finish time in that category. After that, the second ride should start at the later of:

- when the first ride finishes, and
- when the second ride becomes available.

Taking the minimum over both orderings gives the answer.

## Complexity

- Time: $O(n + m)$
- Space: $O(1)$
# 3635. Earliest Finish Time for Land and Water Rides II

This solution computes the earliest possible completion time when taking one land ride and one water ride in either order.

## Idea

1. For a chosen first ride type, find the ride that finishes earliest.
2. Use that finish time as the earliest possible start time for the second ride.
3. For each second ride, compute the actual finish time as the later of:
   - the first ride's finish time, and
   - the second ride's own start time.
4. Try both orderings: land first then water, and water first then land.

## Why it works

For the first ride in an ordering, only the earliest finishing ride matters. Any later first ride cannot improve the final answer because the second ride can never start earlier than the first one finishes.

Once that first finish time is fixed, each candidate second ride is evaluated independently, and the minimum finish time across all candidates gives the best answer for that ordering.

## Complexity

- Time: $O(n + m)$
- Space: $O(1)$
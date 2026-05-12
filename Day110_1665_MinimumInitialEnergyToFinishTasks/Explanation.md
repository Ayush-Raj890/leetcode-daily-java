# 1665. Minimum Initial Energy to Finish Tasks

## Approach
- Sort tasks by `(minimum - actual)` in descending order.
- Start with enough energy to meet the first task's minimum requirement.
- Track current balance after paying each task's actual energy.
- If balance is below the next task's minimum, borrow just enough additional energy.
- Final answer is the initial start plus total borrowed amount.

## Time Complexity
- `O(n log n)` for sorting.

## Space Complexity
- `O(1)` extra space (ignoring sort internals).

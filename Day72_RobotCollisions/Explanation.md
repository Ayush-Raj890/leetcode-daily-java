# 2751. Robot Collisions

## Summary
The solution simulates robots moving on a line and resolves collisions only when a robot moving left meets a robot moving right. Robots are first sorted by position, then a stack is used to keep track of active right-moving robots that may collide with future left-moving robots.

## Key idea
1. Sort robots by their position so collisions are processed in the exact order they can happen on the line.
2. Use a stack to store indices of robots moving right (`'R'`). These are the only robots that can collide with a later left-moving robot.
3. When a left-moving robot (`'L'`) is encountered, compare it with the nearest right-moving robot on the stack:
	- If the right robot has less health, it is destroyed and the left robot loses 1 health, then continues checking the next right robot.
	- If the right robot has more health, the left robot is destroyed and the right robot loses 1 health.
	- If both have the same health, both are destroyed.
4. After all robots are processed, collect the health values of the robots that are still alive in original index order.

## How the code works
1. `order` stores robot indices from `0` to `n - 1`.
2. `Arrays.sort(order, Comparator.comparingInt(i -> pos[i]))` sorts indices by position.
3. `stack` keeps indices of right-moving robots that have not been destroyed yet.
4. `alive[i]` marks whether robot `i` is still alive.
5. For every robot in sorted position order:
	- If it moves right, push its index onto the stack.
	- If it moves left, keep colliding it with the top of the stack until one side is destroyed or the stack becomes empty.
6. At the end, iterate through the original robot order and add the health of each alive robot to the answer list.

## Example
Input:

`pos = [3, 5, 2, 6]`

`h = [10, 10, 15, 12]`

`d = "RLRL"`

After sorting by position, the robot order becomes:

`index 2 (pos 2, L), index 0 (pos 3, R), index 1 (pos 5, L), index 3 (pos 6, L)`

Walkthrough:
- Robot 2 moves left, so nothing happens because the stack is empty.
- Robot 0 moves right, so it is pushed onto the stack.
- Robot 1 moves left and collides with robot 0.
  - Both have health 10, so both are destroyed.
- Robot 3 moves left, and the stack is empty, so it survives.

Final surviving healths:

`[15, 12]`

## Complexity
- Sorting the robots takes `O(n log n)`.
- Each robot is pushed and popped at most once, so the collision simulation is `O(n)`.
- Total time: `O(n log n)`.
- Space: `O(n)` for the stack, sorting array, and alive markers.

## Notes
- The algorithm only resolves collisions between a right-moving robot on the left and a left-moving robot on the right.
- Robots moving in the same direction never collide.
- The result must be returned in the original robot order, not in sorted position order.

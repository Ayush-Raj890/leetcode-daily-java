# Day 78 - Walking Robot Simulation II

**Problem Link:** [LeetCode #2069: Walking Robot Simulation II](https://leetcode.com/problems/walking-robot-simulation-ii/)

---

## Problem Statement
Design a robot that moves on a `width x height` grid.

- The robot starts at `(0, 0)` facing **East**.
- `step(num)` moves the robot `num` steps.
- If the next step goes outside the grid, the robot turns 90 degrees counterclockwise and continues.
- `getPos()` returns the current position.
- `getDir()` returns the current direction.

---

## Approach
Instead of simulating every step directly, we map movement onto the grid perimeter.

1. The robot always moves along the boundary in a fixed cycle:
   - bottom edge (East)
   - right edge (North)
   - top edge (West)
   - left edge (South)
2. Perimeter cycle length:
   - `perimeter = 2 * (width + height) - 4`
3. For each `step(num)`, only `num % perimeter` matters.
4. Keep one integer `distanceOnPerimeter` representing how far the robot is from `(0,0)` along this cycle.
5. Convert that distance to `(x, y)` and direction with segment checks.

Special case:
- Before any movement, direction is `East`.
- After at least one movement, if robot is back at `(0,0)`, direction becomes `South` (end of a full cycle).

---

## Why This Works
- Robot motion is periodic on the boundary, so reducing by modulo perimeter preserves final state.
- Every perimeter distance maps to exactly one boundary cell.
- Direction is determined by which edge segment that distance belongs to.
- The `(0,0)` direction edge case is handled using a `hasMoved` flag.

---

## Time and Space Complexity
- **step(num):** `O(1)`
- **getPos():** `O(1)`
- **getDir():** `O(1)`
- **Space:** `O(1)`

---

## Java Solution
```java
class Robot {
    private final int width;
    private final int height;
    private final int perimeter;

    private int distanceOnPerimeter;
    private boolean hasMoved;

    public Robot(int width, int height) {
        this.width = width;
        this.height = height;
        this.perimeter = 2 * (width + height) - 4;
        this.distanceOnPerimeter = 0;
        this.hasMoved = false;
    }

    public void step(int num) {
        if (num == 0) {
            return;
        }

        hasMoved = true;
        int move = num % perimeter;
        distanceOnPerimeter = (distanceOnPerimeter + move) % perimeter;
    }

    public int[] getPos() {
        int d = distanceOnPerimeter;

        if (d <= width - 1) {
            return new int[] {d, 0};
        }

        if (d <= width + height - 2) {
            return new int[] {width - 1, d - (width - 1)};
        }

        if (d <= 2 * width + height - 3) {
            return new int[] {width - 1 - (d - (width + height - 2)), height - 1};
        }

        return new int[] {0, height - 1 - (d - (2 * width + height - 3))};
    }

    public String getDir() {
        int d = distanceOnPerimeter;

        if (d == 0) {
            return hasMoved ? "South" : "East";
        }

        if (d <= width - 1) {
            return "East";
        }

        if (d <= width + height - 2) {
            return "North";
        }

        if (d <= 2 * width + height - 3) {
            return "West";
        }

        return "South";
    }
}
```

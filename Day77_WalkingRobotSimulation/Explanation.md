# Day 77 - Walking Robot Simulation

**Problem Link:** [LeetCode #874: Walking Robot Simulation](https://leetcode.com/problems/walking-robot-simulation/)

---

## Problem Statement
A robot starts at `(0, 0)` facing north on an infinite grid.

You are given:
- `commands` where:
  - `-2` means turn left 90 degrees
  - `-1` means turn right 90 degrees
  - positive value `k` means move forward `k` steps
- `obstacles`, where each obstacle cell blocks movement

The robot stops moving for the current command when the next cell is blocked, then processes the next command.

Return the maximum Euclidean distance squared from the origin reached at any point.

---

## Approach
1. Store all obstacles in a `HashSet` for `O(1)` lookup.
2. Keep 4 direction vectors in clockwise order:
   - North, East, South, West
3. Track current direction index and robot position `(x, y)`.
4. For each command:
   - Update direction for `-1` / `-2`
   - Otherwise move step-by-step so obstacle checks happen at each cell
5. After each move command, update the answer with:
   - `x * x + y * y`

A coordinate hash is used to store obstacle positions as single `long` keys.

---

## Why This Works
- Turning commands only change direction, never position.
- Forward commands are simulated one step at a time, so the robot correctly stops before obstacles.
- Obstacle checks are constant-time using hashing.
- Maximum distance is checked after each command, guaranteeing the best value is captured.

---

## Time and Space Complexity
- **Time Complexity:** `O(totalSteps + m)`
  - `m` = number of obstacles
  - `totalSteps` = total forward steps actually attempted
- **Space Complexity:** `O(m)`
  - For storing obstacle coordinates in the set

---

## Java Solution
```java
import java.util.HashSet;
import java.util.Set;

class Solution {

    private static final long HASH_MULTIPLIER = 60013;

    public int robotSim(int[] commands, int[][] obstacles) {
        Set<Long> obstacleSet = new HashSet<>();
        for (int[] obstacle : obstacles) {
            obstacleSet.add(hashCoordinates(obstacle[0], obstacle[1]));
        }

        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        int x = 0;
        int y = 0;
        int maxDistanceSquared = 0;
        int currentDirection = 0;

        for (int command : commands) {
            if (command == -1) {
                currentDirection = (currentDirection + 1) % 4;
                continue;
            }
            if (command == -2) {
                currentDirection = (currentDirection + 3) % 4;
                continue;
            }

            int[] direction = directions[currentDirection];
            for (int step = 0; step < command; step++) {
                int nextX = x + direction[0];
                int nextY = y + direction[1];

                if (obstacleSet.contains(hashCoordinates(nextX, nextY))) {
                    break;
                }

                x = nextX;
                y = nextY;
            }

            maxDistanceSquared = Math.max(maxDistanceSquared, x * x + y * y);
        }

        return maxDistanceSquared;
    }

    private long hashCoordinates(long x, long y) {
        return x + HASH_MULTIPLIER * y;
    }
}
```

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
        int currentDirection = 0; // 0: North, 1: East, 2: South, 3: West

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

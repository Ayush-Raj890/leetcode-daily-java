package Day72_RobotCollisions;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.List;

class Solution {
	public List<Integer> survivedRobotsHealths(int[] pos, int[] h, String d) {
		int n = pos.length;
		Integer[] order = new Integer[n];
		for (int i = 0; i < n; i++) {
			order[i] = i;
		}

		Arrays.sort(order, Comparator.comparingInt(i -> pos[i]));

		Deque<Integer> stack = new ArrayDeque<>();
		boolean[] alive = new boolean[n];
		Arrays.fill(alive, true);

		for (int idx : order) {
			if (d.charAt(idx) == 'R') {
				stack.push(idx);
				continue;
			}

			while (!stack.isEmpty() && alive[idx]) {
				int rightIdx = stack.peek();

				if (h[rightIdx] < h[idx]) {
					alive[rightIdx] = false;
					stack.pop();
					h[idx]--;
				} else if (h[rightIdx] > h[idx]) {
					alive[idx] = false;
					h[rightIdx]--;
				} else {
					alive[rightIdx] = false;
					alive[idx] = false;
					stack.pop();
				}

				if (alive[idx] && !stack.isEmpty() && h[rightIdx] > h[idx]) {
					break;
				}
			}
		}

		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			if (alive[i]) {
				result.add(h[i]);
			}
		}
		return result;
	}
}

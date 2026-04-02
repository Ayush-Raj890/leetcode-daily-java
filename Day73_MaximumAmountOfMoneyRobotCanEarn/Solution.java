package Day73_MaximumAmountOfMoneyRobotCanEarn;

import java.util.Arrays;

class Solution {
	public int maximumAmount(int[][] coins) {
		int n = coins.length;
		int m = coins[0].length;
		int negInf = -1_000_000_000;
		int[][][] dp = new int[n][m][3];

		for (int[][] row : dp) {
			for (int[] cell : row) {
				Arrays.fill(cell, negInf);
			}
		}

		for (int used = 0; used < 3; used++) {
			dp[0][0][used] = coins[0][0];
			if (coins[0][0] < 0 && used > 0) {
				dp[0][0][used] = 0;
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (i == 0 && j == 0) {
					continue;
				}

				for (int used = 0; used < 3; used++) {
					int best = negInf;

					if (i > 0) {
						if (dp[i - 1][j][used] != negInf) {
							best = Math.max(best, dp[i - 1][j][used] + coins[i][j]);
						}
						if (coins[i][j] < 0 && used > 0 && dp[i - 1][j][used - 1] != negInf) {
							best = Math.max(best, dp[i - 1][j][used - 1]);
						}
					}

					if (j > 0) {
						if (dp[i][j - 1][used] != negInf) {
							best = Math.max(best, dp[i][j - 1][used] + coins[i][j]);
						}
						if (coins[i][j] < 0 && used > 0 && dp[i][j - 1][used - 1] != negInf) {
							best = Math.max(best, dp[i][j - 1][used - 1]);
						}
					}

					dp[i][j][used] = best;
				}
			}
		}

		return Math.max(dp[n - 1][m - 1][0], Math.max(dp[n - 1][m - 1][1], dp[n - 1][m - 1][2]));
	}
}

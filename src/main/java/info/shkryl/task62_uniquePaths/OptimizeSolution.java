package info.shkryl.task62_uniquePaths;

import java.util.Arrays;

public class OptimizeSolution {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1); // первая строка — все 1

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] = dp[j] + dp[j - 1]; // dp[j] — сверху, dp[j-1] — слева
            }
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.uniquePaths(3, 7);
        System.out.println(result);
    }
}

package info.shkryl.task63_uniquePathsSecond;

public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        // Если старт или финиш заблокированы — путей нет
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) {
            return 0;
        }

        // Создаём DP-таблицу
        int[][] dp = new int[m][n];

        // Инициализация стартовой клетки
        dp[0][0] = 1;

        // Инициализация первой строки
        for (int j = 1; j < n; j++) {
            if (obstacleGrid[0][j] == 0) {
                dp[0][j] = dp[0][j - 1]; // наследуем путь, если нет препятствия
            }
            // иначе остаётся 0 (по умолчанию)
        }

        // Инициализация первого столбца
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] == 0) {
                dp[i][0] = dp[i - 1][0];
            }
        }

        // Заполняем остальную таблицу
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
                // Если препятствие — dp[i][j] остаётся 0
            }
        }

        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] obstacleGrid = {{0,0,0},{0,1,0},{0,0,0}};
        int result = solution.uniquePathsWithObstacles(obstacleGrid);
        System.out.println(result);
    }
}

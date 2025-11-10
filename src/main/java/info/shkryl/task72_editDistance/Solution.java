package info.shkryl.task72_editDistance;

public class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        // dp[i][j] = расстояние между word1[0..i-1] и word2[0..j-1]
        int[][] dp = new int[m + 1][n + 1];

        // База: преобразование в/из пустой строки
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        // Заполняем таблицу
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(
                            dp[i - 1][j],     // удаление
                            Math.min(
                                    dp[i][j - 1], // вставка
                                    dp[i - 1][j - 1] // замена
                            )
                    );
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        String word1 = "horse", word2 = "ros";
        Solution solution = new Solution();
        int result = solution.minDistance(word1, word2);
        System.out.println(result);
    }
}

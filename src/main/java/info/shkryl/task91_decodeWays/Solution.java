package info.shkryl.task91_decodeWays;

class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }

        int n = s.length();
        int[] dp = new int[n + 1];

        // Базовые случаи
        dp[0] = 1; // Пустая строка
        dp[1] = 1; // Первый символ (уже проверили, что не '0')

        for (int i = 2; i <= n; i++) {
            // Вариант 1: одна цифра
            int oneDigit = Integer.parseInt(s.substring(i - 1, i));
            if (oneDigit >= 1 && oneDigit <= 9) {
                dp[i] += dp[i - 1];
            }

            // Вариант 2: две цифры
            int twoDigits = Integer.parseInt(s.substring(i - 2, i));
            if (twoDigits >= 10 && twoDigits <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }
}

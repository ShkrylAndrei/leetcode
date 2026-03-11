package info.shkryl.task96_uniqueBinarySearchTrees;

class Solution {
    public int numTrees(int n) {
        // dp[i] = количество уникальных BST с i узлами
        int[] dp = new int[n + 1];

        // Базовые случаи
        dp[0] = 1;  // Пустое дерево
        dp[1] = 1;  // Один узел

        // Заполняем dp для 2, 3, ..., n узлов
        for (int i = 2; i <= n; i++) {
            // Пробуем каждый узел от 1 до i как корень
            for (int j = 1; j <= i; j++) {
                // Левое поддерево: j-1 узлов
                // Правое поддерево: i-j узлов
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.numTrees(5);
        System.out.println(result);
    }
}

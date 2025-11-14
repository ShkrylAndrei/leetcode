package info.shkryl.task79_wordSearch;

public class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || word == null || word.isEmpty()) {
            return false;
        }

        int rows = board.length;
        int cols = board[0].length;

        // Пробуем начать с каждой клетки
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dfs(board, word, 0, i, j)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String word, int index, int row, int col) {
        // Базовый случай: слово полностью найдено
        if (index == word.length()) {
            return true;
        }

        // Проверка границ и совпадения символа
        if (row < 0 || row >= board.length ||
                col < 0 || col >= board[0].length ||
                board[row][col] != word.charAt(index)) {
            return false;
        }

        // Сохраняем текущий символ и помечаем клетку как посещённую
        char temp = board[row][col];
        board[row][col] = '#'; // спецсимвол — "занято"

        // Рекурсивно проверяем 4 направления
        boolean found =
                dfs(board, word, index + 1, row + 1, col) || // вниз
                        dfs(board, word, index + 1, row - 1, col) || // вверх
                        dfs(board, word, index + 1, row, col + 1) || // вправо
                        dfs(board, word, index + 1, row, col - 1);   // влево

        // Backtrack: возвращаем символ на место
        board[row][col] = temp;

        return found;
    }
}

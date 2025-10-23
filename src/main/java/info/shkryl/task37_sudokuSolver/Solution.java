package info.shkryl.task37_sudokuSolver;

import java.util.Arrays;

public class Solution {
    public void solveSudoku(char[][] board) {
        backtrack(board);
    }

    private boolean backtrack(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    // Пробуем цифры от '1' до '9'
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c; // Ставим цифру

                            if (backtrack(board)) {
                                return true; // Решение найдено!
                            }

                            board[i][j] = '.'; // Откат (backtrack)
                        }
                    }
                    return false; // Ни одна цифра не подошла
                }
            }
        }
        return true; // Все клетки заполнены — решение найдено!
    }

    private boolean isValid(char[][] board, int row, int col, char c) {
        // Проверяем строку
        for (int j = 0; j < 9; j++) {
            if (board[row][j] == c) return false;
        }
        // Проверяем столбец
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == c) return false;
        }
        // Проверяем блок 3x3
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == c) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        Solution solution = new Solution();
        solution.solveSudoku(board);
        System.out.println(Arrays.deepToString(board));
    }
}

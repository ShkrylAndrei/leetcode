package info.shkryl.task36_validSudoku;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Создаём массивы Set'ов для строк, столбцов и блоков
        Set<Character>[] rows = new Set[9];
        Set<Character>[] cols = new Set[9];
        Set<Character>[] boxes = new Set[9];

        // Инициализируем каждый Set
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        // Проходим по каждой клетке
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c == '.') continue; // Пропускаем пустые клетки

                // Номер блока 3x3
                int boxIndex = (i / 3) * 3 + (j / 3);

                // Пытаемся добавить в строку, столбец и блок
                if (!rows[i].add(c) ||
                        !cols[j].add(c) ||
                        !boxes[boxIndex].add(c)) {
                    return false; // Дубликат найден!
                }
            }
        }

        return true; // Всё в порядке!
    }

    public static void main(String[] args) {
        char[][] board =
                {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}
                        , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                        , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                        , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                        , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                        , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                        , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                        , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                        , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        Solution solution = new Solution();
        boolean result = solution.isValidSudoku(board);
        System.out.println(result);
    }
}

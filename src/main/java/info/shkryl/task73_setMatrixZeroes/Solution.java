package info.shkryl.task73_setMatrixZeroes;

import java.util.Arrays;

public class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        // Флаги: нужно ли обнулять первую строку и первый столбец
        boolean firstRowHasZero = false;
        boolean firstColHasZero = false;

        // Проверяем первую строку
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                firstRowHasZero = true;
                break;
            }
        }

        // Проверяем первый столбец
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                firstColHasZero = true;
                break;
            }
        }

        // Используем первую строку и столбец как маркеры
        // Проходим по остальной части матрицы (начиная с [1][1])
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0; // помечаем строку
                    matrix[0][j] = 0; // помечаем столбец
                }
            }
        }

        // Обнуляем строки и столбцы по маркерам
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Обнуляем первую строку, если нужно
        if (firstRowHasZero) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }

        // Обнуляем первый столбец, если нужно
        if (firstColHasZero) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};
        Solution solution = new Solution();
        solution.setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}

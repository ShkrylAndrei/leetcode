package info.shkryl.task22_generateParentheses;

import java.util.*;

public class Solution {

    /**
     * Генерирует все правильные скобочные последовательности из n пар скобок.
     *
     * @param n количество пар скобок
     * @return список всех допустимых комбинаций
     */
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        // Начинаем с пустой строки, 0 открывающих и 0 закрывающих скобок
        backtrack(new StringBuilder(), result, 0, 0, n);
        return result;
    }

    /**
     * Рекурсивная функция backtracking для генерации скобок.
     *
     * @param current     текущая строящаяся строка (используем StringBuilder для эффективности)
     * @param result      список всех валидных комбинаций
     * @param openCount   количество уже добавленных открывающих скобок '('
     * @param closeCount  количество уже добавленных закрывающих скобок ')'
     * @param n           целевое количество пар скобок
     */
    private void backtrack(StringBuilder current, List<String> result,
                           int openCount, int closeCount, int n) {
        // Базовый случай: если строка достигла длины 2*n — комбинация готова
        if (current.length() == 2 * n) {
            result.add(current.toString());
            return;
        }

        // Правило 1: можно добавить открывающую скобку, если их меньше n
        if (openCount < n) {
            current.append('(');
            backtrack(current, result, openCount + 1, closeCount, n);
            current.deleteCharAt(current.length() - 1); // откатываем (backtrack)
        }

        // Правило 2: можно добавить закрывающую скобку, только если их меньше, чем открывающих
        if (closeCount < openCount) {
            current.append(')');
            backtrack(current, result, openCount, closeCount + 1, n);
            current.deleteCharAt(current.length() - 1); // откатываем
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> result = solution.generateParenthesis(4);
        System.out.println(result);
    }
}

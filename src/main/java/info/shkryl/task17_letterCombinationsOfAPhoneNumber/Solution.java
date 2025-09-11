package info.shkryl.task17_letterCombinationsOfAPhoneNumber;

import java.util.*;

public class Solution {

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        // Если пустая строка — возвращаем пустой список
        if (digits == null || digits.isEmpty()) {
            return result;
        }

        // Маппинг цифр на буквы
        String[] digitToLetters = {
                "",     // 0
                "",     // 1
                "abc",  // 2
                "def",  // 3
                "ghi",  // 4
                "jkl",  // 5
                "mno",  // 6
                "pqrs", // 7
                "tuv",  // 8
                "wxyz"  // 9
        };

        backtrack(digits, 0, new StringBuilder(), result, digitToLetters);
        return result;
    }

    private void backtrack(String digits, int index, StringBuilder current, List<String> result, String[] mapping) {
        // Базовый случай: если дошли до конца — добавляем комбинацию
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        // Получаем текущую цифру и соответствующие буквы
        int digit = digits.charAt(index) - '0';
        String letters = mapping[digit];

        // Перебираем все буквы для этой цифры
        for (char letter : letters.toCharArray()) {
            current.append(letter); // Добавляем букву
            backtrack(digits, index + 1, current, result, mapping); // Рекурсивно обрабатываем следующую цифру
            current.deleteCharAt(current.length() - 1); // Убираем букву (backtrack)
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String digits = "23";
        List<String> result = solution.letterCombinations(digits);
        System.out.println(result);
    }
}

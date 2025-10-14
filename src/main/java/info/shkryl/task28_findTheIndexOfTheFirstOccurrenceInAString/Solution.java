package info.shkryl.task28_findTheIndexOfTheFirstOccurrenceInAString;

public class Solution {
    public int strStr(String haystack, String needle) {
        // Крайний случай: пустая иголка — возвращаем 0
        if (needle.isEmpty()) {
            return 0;
        }

        int n = haystack.length();
        int m = needle.length();

        // Если иголка длиннее стога — не может быть вхождения
        if (m > n) {
            return -1;
        }

        // Проходим по каждому возможному стартовому индексу
        for (int i = 0; i <= n - m; i++) {
            // Проверяем, совпадает ли подстрока haystack[i..i+m-1] с needle
            boolean found = true;
            for (int j = 0; j < m; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    found = false;
                    break; // Символ не совпал — выходим из внутреннего цикла
                }
            }
            if (found) {
                return i; // Нашли первое вхождение!
            }
        }

        return -1; // Ничего не найдено
    }
}

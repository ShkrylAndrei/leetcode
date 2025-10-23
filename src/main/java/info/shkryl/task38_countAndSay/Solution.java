package info.shkryl.task38_countAndSay;

public class Solution {
    public String countAndSay(int n) {
        // Базовый случай
        String result = "1";

        // Генерируем последовательность от 2 до n
        for (int i = 2; i <= n; i++) {
            result = buildNext(result);
        }

        return result;
    }

    // Вспомогательный метод: строит следующий элемент последовательности
    private String buildNext(String s) {
        StringBuilder next = new StringBuilder();
        int i = 0;

        while (i < s.length()) {
            char currentChar = s.charAt(i);
            int count = 0;

            // Считаем, сколько раз подряд встречается currentChar
            while (i < s.length() && s.charAt(i) == currentChar) {
                count++;
                i++;
            }

            // Добавляем "счёт" и "символ"
            next.append(count).append(currentChar);
        }

        return next.toString();
    }

    public static void main(String[] args) {
        int input = 4;
        Solution solution = new Solution();
        String result = solution.countAndSay(input);
        System.out.println(result);
    }
}
